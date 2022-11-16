package j1lab3;
public abstract class ComLineParserBase {
    private String[] keys; ////почему нужен private? для надежности?/////
    private String[] delimeters;
    
    // варианты завершения разбора командной строки
    protected enum SwitchStatus { NoError, Error, ShowUsage };

    public ComLineParserBase(String[] keys) {
        this(keys,new String[]{"/","-"}); //почему new? потому что так объявляются ананомные массивы.
    }

    public ComLineParserBase(String[] keys, String[] delimeters) {
        this.keys = keys;
        this.delimeters = delimeters;
    }
    
    protected abstract void OnUsage(String errorKey);
    
    protected SwitchStatus OnSwitch(String key,String keyValue){
//        System.out.println(key+": "+keyValue);
        return SwitchStatus.NoError;
    }
    
    public final boolean Parse(String[] args){ ////// почему с большой Boolean (обертка), а не boolean?//////
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
                boolean isKey=false; //// почему с большой Boolean (обертка), а не boolean////////
                int i;
                for (i = 0; !isKey && (i < keys.length); i++) {
                    isKey = args[argNum].toUpperCase().regionMatches(1,keys[i].toUpperCase(),0,keys[i].length()); // перваяСтрока.regionMatches(символСКкоторогоНачинаетсяСравнениеПервойСтроки, второаяСтрока, символСКкоторогоНачинаетсяСравнениеВторойСтроки, длиннаСравниваемыхПодстрок)
                    if (isKey) break;
                }
                if(!isKey){
                    ss=SwitchStatus.Error;
                    break;
///////////////////Без этого кода OnSwitch вообще не вызывается. inFile и outFile получить невозможно. Взял его из решения, в инструкции на него указаний не нашел////
                } else{
                ss = OnSwitch(keys[i].toLowerCase(), 
                args[argNum].substring(1 + keys[i].length())); 
////////////////////////////////////////////////////////////////////////////////
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
