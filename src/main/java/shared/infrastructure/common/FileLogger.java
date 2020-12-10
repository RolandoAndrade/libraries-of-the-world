package shared.infrastructure.common;

import shared.domain.logging.LoggerService;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger implements LoggerService {

    public FileLogger(){
        try {
            File myObj = new File("log.txt");
            myObj.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private String buildLog(String context, String type, String log, String data) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        String nowAsISO = df.format(new Date());
        return nowAsISO + "  [" + type + "]" + "  [" + context + "]  " + log + data;
    }

    private void writeLog(String log){
        try(FileWriter fw = new FileWriter("log.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(log);
        } catch (IOException e) {

        }
    }

    @Override
    public void info(String log, String context, Object data) {
        writeLog(this.buildLog(context, "INFO", log, data.toString()));
    }

    @Override
    public void log(String log, String context, Object data) {
        writeLog(this.buildLog(context, "LOG", log, data.toString()));
    }

    @Override
    public void warn(String log, String context, Object data) {
        writeLog(this.buildLog(context, "WARN", log, data.toString()));
    }

    @Override
    public void error(String log, String context, Object data) {
        writeLog(this.buildLog(context, "ERROR", log, data.toString()));
    }
}