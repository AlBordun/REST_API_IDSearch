package first.Model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Getter
@Data
@Value
//@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@Builder
public class CurrencyRate {

    String numCode;
    String charCode;
    String nominal;
    String name;
    String value;

    public CurrencyRate(@JsonProperty("numCode") String numCode,
                        @JsonProperty("charCode") String charCode,
                        @JsonProperty("nominal") String nominal,
                        @JsonProperty("name") String name,
                        @JsonProperty("value") String value) {
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
    }
}
