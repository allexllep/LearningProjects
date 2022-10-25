package j1lab2;
public class ComLineParser {
    private String[] keys;
    private String[] delimeters;
    
    // варианты завершения разбора командной строки
    public enum SwitchStatus { NoError, Error, ShowUsage };

    public ComLineParser(String[] keys) {
        this(keys,new String[]{"/","-"});
    }

    public ComLineParser(String[] keys, String[] delimeters) {
        this.keys = keys;
        this.delimeters = delimeters;
    }
    
    public void OnUsage(String errorKey){
        if (errorKey!=null) System.out.println("error key: "+errorKey);
        System.out.println("формат ком.строки: имяПрограммы [-r<input-fileName>] [-w<output-fileName>]");
        System.out.println("   -?  показать Help файл");
        System.out.println("   -r  задать имя входного файла");
        System.out.println("   -w  выполнить вывод в указанный файл");
        
    };
    
    public SwitchStatus OnSwitch(String key,String keyValue){
        System.out.println(key+": "+keyValue);
        return SwitchStatus.NoError;
    }
    
    public boolean Parse(String[] args){
        SwitchStatus ss = SwitchStatus.NoError;	    
        int argNum;
        for (argNum = 0; (ss == SwitchStatus.NoError) && (argNum < args.length); argNum++) {
            
        // провера наличия правильного разделителя
            boolean isDelimeter = false;
            for (int n = 0; !isDelimeter && (n < delimeters.length); n++) {
               	 isDelimeter = args[argNum].regionMatches(0,delimeters[n], 0, 1);
            }
            
            if (isDelimeter) {                
                // проверка наличия правильного ключа
                boolean isKey=false;
                int i;
                for (i = 0; !isKey && (i < keys.length); i++) {
                    isKey = args[argNum].toUpperCase().regionMatches(1,keys[i].toUpperCase(),0,keys[i].length()); // перваяСтрока.regionMatches(символСКкоторогоНачинаетсяСравнениеПервойСтроки, второаяСтрока, символСКкоторогоНачинаетсяСравнениеВторойСтроки, длиннаСравниваемыхПодстрок)
                    if (isKey) break;
                }
                if(!isKey){
                    ss=SwitchStatus.Error;
                    break;
                }       
            } else {
                ss=SwitchStatus.Error;
                break;
            }
        }
        
        // завершение разбора командной строки
        if (ss == SwitchStatus.ShowUsage)    OnUsage(null);
        if (ss == SwitchStatus.Error)        OnUsage((argNum == args.length) ? null : args[argNum]);
        return ss==SwitchStatus.NoError;
    }
}
