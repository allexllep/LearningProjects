package j1lab3;
public class SimpleParser extends ComLineParserBase{
    private String inFile, outFile;

    public String getInFile() {
        return inFile;
    }

    public String getOutFile() {
        return outFile;
    }

    public SimpleParser(String[] keys) {
        super(keys);
    }      
    
    @Override
    protected void OnUsage(String errorKey){
        if (errorKey!=null) System.out.println("error key: "+errorKey);
        System.out.println("формат ком.строки: имяПрограммы [-r<input-fileName>] [-w<output-fileName>]");
        System.out.println("   -?  показать Help файл");
        System.out.println("   -r  задать имя входного файла");
        System.out.println("   -w  выполнить вывод в указанный файл");
       
    };
    
    @Override
    protected SwitchStatus OnSwitch(String key,String keyValue){
        SwitchStatus status=SwitchStatus.NoError;
        switch (key) {
            case "?": status=SwitchStatus.ShowUsage; break;
            case "r":
                if (keyValue!=null){
                    inFile=keyValue;
                } else{
                    System.out.println("Ошибка по ключу r. Из какого файла брать запись?");
                    status=SwitchStatus.Error;
                }
                break;
                case "w":
                if (keyValue!=null){
                    outFile=keyValue;
                } else{
                    System.out.println("Ошибка по ключу w. В какой файл вести запись?");
                    status=SwitchStatus.Error;
                } break;
            default: status=SwitchStatus.Error; break;
        }
        return status;
    }
}
