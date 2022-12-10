package com.example.demo.handler;

import com.example.demo.entity.CodeEnum;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.type.*;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Stream;

@MappedTypes(CodeEnum.class)
@MappedJdbcTypes(JdbcType.INTEGER)
@RequiredArgsConstructor
public abstract class CodeEnumTypeHandler<E extends Enum<E> & CodeEnum> implements TypeHandler<CodeEnum> {

    private final Class<E> type;

    @Override
    public void setParameter(PreparedStatement ps, int i, CodeEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getId());
    }

    @Override
    public CodeEnum getResult(ResultSet rs, String columnName) throws SQLException {
        return getEnumById(rs.getInt(columnName));
    }

    @Override
    public CodeEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        return getEnumById(rs.getInt(columnIndex));
    }

    @Override
    public CodeEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getEnumById(cs.getInt(columnIndex));
    }
    private CodeEnum getEnumById(Integer id) {
        return Stream.of(type.getEnumConstants())
                .filter(codeEnum -> codeEnum.getId() == id)
                .findFirst()
                .orElseThrow(TypeException::new);
    }


}