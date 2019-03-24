package com.iknowyou.infra.serializer;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import org.springframework.util.ObjectUtils;

import com.iknowyou.domain.medicalhistory.MedicalHistory;

import lombok.AllArgsConstructor;

public class MedicalHistorySerializer extends AbstractSerializer<MedicalHistory>{

	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	
	@Override
	protected void serialize(final MedicalHistory history, final JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        serializeMedicalHistory(history, jsonWriter);
        jsonWriter.writeEndObject();
	}

	
    private void serializeMedicalHistory(final MedicalHistory history, final JsonWriter jsonWriter) throws IOException {
        if (!ObjectUtils.isEmpty(history)) {
            jsonWriter.writeNumberField(Field.ID, history.getId());
            jsonWriter.writeStringField(Field.HISTORY_DATE, history.getHistoryDate().format(DATE_TIME_FORMATTER));
            jsonWriter.writeStringField(Field.NOTE,history.getNote());
            jsonWriter.writeNumberField(Field.PATIENT_ID, history.getPatient().getId());
        }		
	}


	@AllArgsConstructor
    private enum Field {

        ID("id"),
        HISTORY_DATE("historyDate"),
        NOTE("note"),
        PATIENT_ID("patient_id");

        private final String label;

        @Override
        public String toString() {
            return this.label;
        }
    }
	
}
