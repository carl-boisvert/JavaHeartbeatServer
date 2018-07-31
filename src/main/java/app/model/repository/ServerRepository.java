package app.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import app.model.server.Server;

import java.util.List;

public interface ServerRepository  extends MongoRepository<Server, String> {

    Server findOneByUrl(@Param("url") String url);

    List<Server> findByNextExecutionDateLessThan(long timestamp);
}
