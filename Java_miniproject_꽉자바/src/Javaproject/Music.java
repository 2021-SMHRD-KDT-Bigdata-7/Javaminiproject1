package Javaproject;
import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
public class Music {
       public void ASingularStrike() {
              File bgm;
              AudioInputStream stream;
              AudioFormat format;
              DataLine.Info info;
              bgm = new File("C:/Users/smhrd/Desktop/JAVAstudy/Javaminiproject1/Java_miniproject_���ڹ�/music/ASingularStrike.wav"); // ���ÿ��� ���� ������ ������ ��
              Clip clip;
              try {
                     stream = AudioSystem.getAudioInputStream(bgm);
                     format = stream.getFormat();
                     info = new DataLine.Info(Clip.class, format);
                     clip = (Clip)AudioSystem.getLine(info);
                     clip.open(stream);
                     clip.start();      
              } catch (Exception e) {
                     System.out.println("err : " + e);
                     }    
       }
       public void BattleBrothers() {
           File bgm;
           AudioInputStream stream;
           AudioFormat format;
           DataLine.Info info;
           bgm = new File("C:/Users/smhrd/Desktop/JAVAstudy/Javaminiproject1/Java_miniproject_���ڹ�/music/BattleBrothers.wav"); // ���ÿ��� ���� ������ ������ ��
           Clip clip;
           try {
                  stream = AudioSystem.getAudioInputStream(bgm);
                  format = stream.getFormat();
                  info = new DataLine.Info(Clip.class, format);
                  clip = (Clip)AudioSystem.getLine(info);
                  clip.open(stream);
                  clip.start();      
           } catch (Exception e) {
                  System.out.println("err : " + e);
                  }    
    }
       public void AirCut() {
           File bgm;
           AudioInputStream stream;
           AudioFormat format;
           DataLine.Info info;
           bgm = new File("C:/Users/smhrd/Desktop/JAVAstudy/Javaminiproject1/Java_miniproject_���ڹ�/music/AirCut.wav"); // ���ÿ��� ���� ������ ������ ��
           Clip clip;
           try {
                  stream = AudioSystem.getAudioInputStream(bgm);
                  format = stream.getFormat();
                  info = new DataLine.Info(Clip.class, format);
                  clip = (Clip)AudioSystem.getLine(info);
                  clip.open(stream);
                  clip.start();      
           } catch (Exception e) {
                  System.out.println("err : " + e);
                  }    
    }
       public void Bloody() {
           File bgm;
           AudioInputStream stream;
           AudioFormat format;
           DataLine.Info info;
           bgm = new File("C:/Users/smhrd/Desktop/JAVAstudy/Javaminiproject1/Java_miniproject_���ڹ�/music/Bloody.wav"); // ���ÿ��� ���� ������ ������ ��
           Clip clip;
           try {
                  stream = AudioSystem.getAudioInputStream(bgm);
                  format = stream.getFormat();
                  info = new DataLine.Info(Clip.class, format);
                  clip = (Clip)AudioSystem.getLine(info);
                  clip.open(stream);
                  clip.start();      
           } catch (Exception e) {
                  System.out.println("err : " + e);
                  }    
    }
}