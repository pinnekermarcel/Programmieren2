package lektion18;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import lektion18.ToUpperCase.ToUpperCaseWriter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ToUpperCaseWriterTest
{


  @Test
  public void writeCharTest()
  {
    checkCharWrite('a', "A");
  }

  @Test
  public void writeCharTestWithNonChar()
  {
    checkCharWrite('1', "1");
  }
  //Hilfsmethode
  public void checkCharWrite(char input, String expectedOutput){
      //try-with-resources
      try(
              ByteArrayOutputStream baos = new ByteArrayOutputStream();//sammelt daten
              OutputStreamWriter osw = new OutputStreamWriter(baos);//Buchstaben zu byte
              ToUpperCaseWriter writer = new ToUpperCaseWriter(osw);//filter
              ){
          //Das Zeichen in den Stream
          writer.write(input);
          //puffer leeren
          writer.flush();
          //test ob ergebnis der erwartung entspricht
          assertEquals(expectedOutput, baos.toString());
      }catch(IOException e){
          fail("IOException" + e.getMessage());
      }
  }
  @Test
    public void writeLowerCasetest(){
      for(char c = 'a'; c <= 'z'; c++){
            checkCharWrite(c, String.valueOf(c).toUpperCase());
      }
  }
  @Test
    public void withOtherCharsTest(){
      for(int i = 0; i < 128; i++){
          char c = (char)i;

          //wenn kein kleiner buchstabe...
          if(!(c >= 'a' && c <= 'z')){
              //dann hilfsmethode
              checkCharWrite(c, String.valueOf(c));
          }
      }
  }

}
