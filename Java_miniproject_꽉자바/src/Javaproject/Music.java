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
              bgm = new File("C:\\Users\\sang0\\git\\Javaminiproject1\\Java_miniproject_���ڹ�\\music\\miniStrike.wav"); // ���ÿ��� ���� ������ ������ ��
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
           bgm = new File("C:\\Users\\sang0\\git\\Javaminiproject1\\Java_miniproject_���ڹ�\\music\\BattleBrotherswav.wav"); // ���ÿ��� ���� ������ ������ ��
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
           bgm = new File("C:\\Users\\sang0\\git\\Javaminiproject1\\Java_miniproject_���ڹ�\\music\\AirCut.wav"); // ���ÿ��� ���� ������ ������ ��
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
           bgm = new File("C:\\Users\\sang0\\git\\Javaminiproject1\\Java_miniproject_���ڹ�\\music\\Bloody.wav"); // ���ÿ��� ���� ������ ������ ��
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
       public void Fireball() {
           File bgm;
           AudioInputStream stream;
           AudioFormat format;
           DataLine.Info info;
           bgm = new File("C:\\Users\\sang0\\git\\Javaminiproject1\\Java_miniproject_���ڹ�\\music\\fireBall.wav"); // ���ÿ��� ���� ������ ������ ��
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
       public void Determination() {
           File bgm;
           AudioInputStream stream;
           AudioFormat format;
           DataLine.Info info;
           bgm = new File("C:\\Users\\sang0\\git\\Javaminiproject1\\Java_miniproject_���ڹ�\\music\\shrineofenirhs.wav"); // ���ÿ��� ���� ������ ������ ��
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
       public void gunshot1() {
           File bgm;
           AudioInputStream stream;
           AudioFormat format;
           DataLine.Info info;
           bgm = new File("C:\\Users\\sang0\\git\\Javaminiproject1\\Java_miniproject_���ڹ�\\music\\gunshot.wav"); // ���ÿ��� ���� ������ ������ ��
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
       public void gunshot2() {
           File bgm;
           AudioInputStream stream;
           AudioFormat format;
           DataLine.Info info;
           bgm = new File("C:\\Users\\sang0\\git\\Javaminiproject1\\Java_miniproject_���ڹ�\\music\\524912__andrest2003__gunshot-pitch-a.wav"); // ���ÿ��� ���� ������ ������ ��
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