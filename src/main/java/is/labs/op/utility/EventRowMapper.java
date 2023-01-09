package is.labs.op.utility;

import org.springframework.jdbc.core.RowMapper;
import ru.quipy.domain.EventRecord;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class EventRowMapper implements RowMapper<EventRecord> {

    @Override
    public EventRecord mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long aggregateVersion = null;
        String payload = "???";
        Long createdAd = null;

        EventRecord record = new EventRecord(
                rs.getString("id"),
                rs.getString("object_id"),
                aggregateVersion,
                rs.getString("event_type"),
                payload,
                createdAd
        );

        return record;
    }
}
