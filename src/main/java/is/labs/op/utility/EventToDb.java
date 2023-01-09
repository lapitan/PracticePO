package is.labs.op.utility;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.quipy.core.exceptions.DuplicateEventIdException;
import ru.quipy.database.EventStore;
import ru.quipy.domain.ActiveEventStreamReader;
import ru.quipy.domain.EventRecord;
import ru.quipy.domain.EventStreamReadIndex;
import ru.quipy.domain.Snapshot;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.UUID;

@Component
public class EventToDb implements EventStore {

    JdbcTemplate jdbcTemplate;

    public EventToDb(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void commitStreamReadIndex(@NotNull EventStreamReadIndex eventStreamReadIndex) {
        throw new RuntimeException("ABOBA");
        //todo
    }
    @Nullable
    @Override
    public Snapshot findSnapshotByAggregateId(@NotNull String aggregateTableName, @NotNull Object o) {
        throw new RuntimeException("ABOBA");
        //return null;
    }

    @Nullable
    @Override
    public EventStreamReadIndex findStreamReadIndex(@NotNull String aggregateTableName) {
        throw new RuntimeException("ABOBA");
        //return null; //todo
    }

    @Nullable
    @Override
    public ActiveEventStreamReader getActiveStreamReader(@NotNull String aggregateTableName) {
        throw new RuntimeException("ABOBA");
        //return null;  //todo
    }

    @Override
    public void insertEventRecord(@NotNull String aggregateTableName, @NotNull EventRecord eventRecord) throws DuplicateEventIdException {
        try {
            final String INSERT_SQL = "INSERT INTO " + aggregateTableName + "(OBJECT_ID, EVENT_TYPE, DATA) VALUES (?,?,?)";
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(
                    connection -> {
                        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, new String[]{"id"});
                        preparedStatement.setString(1, eventRecord.component1());
                        preparedStatement.setString(2, eventRecord.getEventTitle());
                        preparedStatement.setString(3, eventRecord.component4());
                        return preparedStatement;
                    }
                    , keyHolder);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEventIdException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public boolean tableExists(@NotNull String aggregateTableName) {
        String query="SELECT EXISTS (" +
                "   SELECT FROM pg_tables" +
                "   WHERE  schemaname = 'public'" +
                "   AND    tablename  = '"+aggregateTableName+"'" +
                "   )";
        return jdbcTemplate.queryForObject(query, Boolean.class);
    }

    @Override
    public void updateSnapshotWithLatestVersion(@NotNull String aggregateTableName, @NotNull Snapshot snapshot) {

    }

    @Override
    public void insertEventRecords(@NotNull String aggregateTableName, @NotNull List<EventRecord> list) throws DuplicateEventIdException {
        list.forEach((record) -> {
            insertEventRecord(aggregateTableName, record);
        });
    }

    @NotNull
    @Override
    public List<EventRecord> findBatchOfEventRecordAfter(@NotNull String aggregateTableName, long eventSequenceNum, int batchSize) {
        String query = "SELECT * " +
                "FROM ? " +
                "WHERE createdAt > ? "+
                "ORDER BY createdAt "+
                "LIMIT ?";
        return jdbcTemplate.query(query, new EventRowMapper(),aggregateTableName,eventSequenceNum,batchSize);
    }

    @NotNull
    @Override
    public List<EventRecord> findEventRecordsWithAggregateVersionGraterThan(@NotNull String aggregateTableName, @NotNull Object aggregateId, long aggregateVersion) {
        String query="SELECT * "+
                "FROM ? "+
                "WHERE aggregateId = ? "+
                "AND aggregateVersion > ?";
        return jdbcTemplate.query(query, new EventRowMapper(),aggregateTableName,aggregateId,aggregateVersion);
    }
}
