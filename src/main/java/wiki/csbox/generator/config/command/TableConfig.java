package wiki.csbox.generator.config.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableConfig {

    private List<Object> list = new ArrayList<>();

    private Map<String, Object> map = new HashMap<>();


    public TableConfig(List<Object> list) {
        if (list != null) this.list = list;
    }

    public TableConfig(Map<String, Object> map) {
        if (map != null) this.map = map;
    }
}
