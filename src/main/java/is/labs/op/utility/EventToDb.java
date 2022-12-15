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
import ru.quipy.database.EventStoreDbOperations;
import ru.quipy.domain.ActiveEventStreamReader;
import ru.quipy.domain.EventRecord;
import ru.quipy.domain.EventStreamReadIndex;
import ru.quipy.domain.Snapshot;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.UUID;

@Component
public class EventToDb implements EventStoreDbOperations {

    JdbcTemplate jdbcTemplate;

    public EventToDb(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void commitStreamReadIndex(@NotNull EventStreamReadIndex eventStreamReadIndex) {
        //todo
    }

    @NotNull
    @Override
    public List<EventRecord> findBatchOfEventRecordAfter(@NotNull String s, long l, int i) {

        String query="SELECT *";

        /*UUID uuid= ;*/

        return null;
    }

    @NotNull
    @Override
    public List<EventRecord> findEventRecordsWithAggregateVersionGraterThan(@NotNull String s, @NotNull Object o, long l) {
        return null;
    }

    @Nullable
    @Override
    public Snapshot findSnapshotByAggregateId(@NotNull String s, @NotNull Object o) {
        return null;
    }

    @Nullable
    @Override
    public EventStreamReadIndex findStreamReadIndex(@NotNull String s) {
        return null; //todo
    }

    @Nullable
    @Override
    public ActiveEventStreamReader getActiveStreamReader(@NotNull String s) {
        return null;  //todo
    }

    @Override
    public void insertEventRecord(@NotNull String s, @NotNull EventRecord eventRecord) throws DuplicateEventIdException {
        try {
            final String INSERT_SQL = "INSERT INTO "+s+"(OBJECT_ID, EVENT_TYPE, DATA) VALUES (?,?,?)";
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(
                connection->{
                    PreparedStatement preparedStatement= connection.prepareStatement(INSERT_SQL, new String[]{"id"});
                    preparedStatement.setString(1, eventRecord.component1());
                    preparedStatement.setString(2, eventRecord.getEventTitle());
                    preparedStatement.setString(3, eventRecord.component4());
                    return preparedStatement;
                }
            ,keyHolder);
        }catch (DataIntegrityViolationException e){
            throw new DuplicateEventIdException(e.getMessage(),e.getCause());
        }
    }

    @Override
    public boolean tableExists(@NotNull String s) {
        return false;
    }

    @Override
    public void updateSnapshotWithLatestVersion(@NotNull String s, @NotNull Snapshot snapshot) {

    }
}
