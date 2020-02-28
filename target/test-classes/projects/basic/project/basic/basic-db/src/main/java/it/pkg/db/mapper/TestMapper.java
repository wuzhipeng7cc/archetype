package it.pkg.db.mapper;

import it.pkg.db.config.MyMapper;
import it.pkg.db.model.Test;
import org.springframework.stereotype.Component;

@Component
public interface TestMapper extends MyMapper<Test> {
}