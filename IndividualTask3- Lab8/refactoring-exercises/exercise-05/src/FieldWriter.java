public class FieldWriter {
    void writeField(String field) {
        if (field.indexOf(',') != -1 || field.indexOf('\"') != -1)
            writeQuoted(field);
        else
            System.out.print(field);
    }
    void writeQuoted(String field) {
        System.out.print('\"');
        for (int i = 0; i < field.length(); i++) {
            char c = field.charAt(i);
            if (c == '\"')
                System.out.print("\"\"");
            else
                System.out.print(c);
        }
        System.out.print('\"');
    }
}
