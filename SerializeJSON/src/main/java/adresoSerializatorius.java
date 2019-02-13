import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class adresoSerializatorius extends StdSerializer<Adresas> {
    public adresoSerializatorius() {
        super((Class<Adresas>) null);
    }

    protected adresoSerializatorius(Class<Adresas> t) {
        super(t);
    }






    @Override
    public void serialize(Adresas adresas, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("street", adresas.getGatve());
        jsonGenerator.writeStringField("city", adresas.getMiestas());
        jsonGenerator.writeStringField("country", String.valueOf(adresas.getSalis()));
        jsonGenerator.writeStringField("number", adresas.getNamoNr());
        jsonGenerator.writeEndObject();
    }
}
