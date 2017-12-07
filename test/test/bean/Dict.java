package test.bean;

import com.hjc.common.util.migrate.Row;
import lombok.Getter;
import lombok.Setter;

public class Dict {
    @Row(index = 1,rowName = "id",rowClass = String.class)
    @Getter
    @Setter
    private String a;
}
