#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.db.mapper;

import ${package}.db.config.MyMapper;
import ${package}.db.model.Test;
import org.springframework.stereotype.Component;

@Component
public interface TestMapper extends MyMapper<Test> {
}