import java.util.HashMap;
import java.util.Map;

//Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
//Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.

public class Class2Solution1 {
    public static void main(String[] args) {
        Map<String, String> input = new HashMap<String,String>();
        input.put("name","Ivanov");
        input.put("country","Russia");
        input.put("city","Moscow");
        input.put("age",null);
        System.out.println(getQuery(input));
    }
    public static String getQuery(Map<String, String> params)
    {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String,String> pair : params.entrySet())
        {
            if (pair.getValue() != null)
            {
                sb.append(pair.getKey() +" = '" + pair.getValue()+"' and ");
            }
        }
        sb.delete(sb.toString().length()-5,sb.toString().length());
        return sb.toString();
    }
}
