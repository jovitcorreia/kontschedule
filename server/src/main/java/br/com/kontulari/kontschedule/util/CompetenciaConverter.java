package br.com.kontulari.kontschedule.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.Instant;
import java.time.YearMonth;
import java.time.ZoneId;

@Converter
public class CompetenciaConverter implements AttributeConverter<YearMonth, Date> {
  @Override
  public Date convertToDatabaseColumn(YearMonth yearMonth) {
    return java.sql.Date.valueOf(yearMonth.atDay(1));
  }

  @Override
  public YearMonth convertToEntityAttribute(Date date) {
    return YearMonth.from(
        Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
  }
}
