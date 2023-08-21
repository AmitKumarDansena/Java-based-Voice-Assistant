import java.io.IOException;                     //used for handling errors which can occur during input/output operations
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.awt.Desktop;   //(Abstract Window Toollkit) used for opening windows application

//for the voice
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

//for browser searches
import org.openqa.selenium.WebDriver;            //by including it we can interact with the web pages
import org.openqa.selenium.chrome.ChromeDriver;    //by including it we can interact with the Google Chrome browser
import java.io.File;                               //by including it we can work with file and directories


//this class is for Greeting!
class wishme{

    wishme(){
        Voice voice;
        VoiceManager voiceManager=VoiceManager.getInstance();        //it is used to get access to the voice
        voice=voiceManager.getVoice("kevin16");
        voice.allocate();          //used for assigning the voice
        voice.setVolume(1.0f);     //used for setting the volume
        voice.setRate(120);        //used for setting wpm
        voice.setStyle("robotic");
        LocalTime currentTime=LocalTime.now();        //for getting the current time
        int hour=currentTime.getHour();
        if(hour>=0&&hour<12){
            voice.speak("Good Morning! Sir");
        } else if (hour>=12&&hour<18) {
            voice.speak("Good Afternoon! Sir");
        }
        else {
            voice.speak("Good Evening! Sir");
        }

        voice.speak("I am Kevin sir, Please tell me how may i help you");
    }
}
class TextSpeech extends wishme {

    public static void main(String[] args) throws IOException{                   // throw keyword is used to transfer control from the try block to the catch block.

        //this is for including Voice!
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us" + ".cmu_us_kal.KevinVoiceDirectory");      //for setting which voice library user want to include
        Voice voice;
        VoiceManager voiceManager=VoiceManager.getInstance();
        voice=voiceManager.getVoice("kevin16");
        voice.allocate();
        voice.setVolume(1.0f);
        voice.setRate(120);
        voice.setStyle("robotic");


        wishme wm = new wishme();                       //calling Constructor
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------JUST ASK------------------------");

        //For taking commands
        boolean flag=true;
                while(flag==true) {
                    String str = sc.nextLine();

                    switch (str) {
                        case ("what is the time"):
                            LocalTime currentTime = LocalTime.now();
                            voice.speak("The current time is " + currentTime);
                            break;
                        case ("what is today's date"):
                            LocalDate date = LocalDate.now();
                            voice.speak("Today's date is " + date);
                            break;
                        case ("what is the day today"):
                            LocalDate currentdate = LocalDate.now();
                            DayOfWeek day = currentdate.getDayOfWeek();
                            voice.speak("Today is " + day);
                            break;
                        case ("open chrome"):
                            voice.speak("Opening Chrome browser.");
                            WebDriver driver = new ChromeDriver();    //For Searching on browser
                            String url = "https://www.google.com";
                            driver.get(url);            //to open a specified link.
                            break;
                        case ("open youtube"):
                            voice.speak("Opening Youtube on browser.");
                            WebDriver drivers = new ChromeDriver();   //For Searching on browser
                            String url1 = "https://www.youtube.com";
                            drivers.get(url1);
                            break;
                        case ("open linkedin"):
                            voice.speak("Opening Linkedin on browser");   //For Searching on browser
                            WebDriver driver3 = new ChromeDriver();
                            String url2 = "https://www.linkedin.com";
                            driver3.get(url2);
                            break;
                        case ("open UMS"):
                            voice.speak("Opening University Management System of Lovely Professional University");
                            WebDriver driver4 = new ChromeDriver();          //For Searching on browser
                            String url3 = "https://ums.lpu.in/lpuums";
                            driver4.get(url3);
                            break;
                        case ("open LPU Live"):
                            voice.speak("Opening Lovely Professional University live messanger on web browser");
                            WebDriver driver5 = new ChromeDriver();       //For Searching on browser and for automating interaction with the web application
                            String url4 = "https://lpulive.lpu.in/login";
                            driver5.get(url4);
                            break;
                        case ("open virtualbox"):
                            voice.speak("Opening Virtual Box for Kali");
                            String filePath = "C:\\Program Files\\Oracle\\VirtualBox\\VirtualBox.exe"; // Path to the application you want to launch
                            try {
                                File file = new File(filePath);
                                Desktop.getDesktop().open(file);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case ("open Camera"):
                            voice.speak("Opening Camera of Windows");
                            String filePath1 = "C:\\Users\\adity\\OneDrive\\Desktop\\Camera.url"; // Path to the application you want to launch
                            try {
                                File file = new File(filePath1);
                                Desktop.getDesktop().open(file);
                            } catch (IOException e) {
                                e.printStackTrace();             //if any exception is there then it can be used to show the classname line number where the error occured
                            }
                            break;
                        case ("open Calculator"):
                            voice.speak("Opening Calculator of Windows");
                            String filePath2 = "C:\\Users\\adity\\OneDrive\\Desktop\\calc.lnk"; // Path to the application you want to launch
                            try {
                                File file = new File(filePath2);
                                Desktop.getDesktop().open(file);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case ("open Microsoft Word"):
                            voice.speak("Opening Microsoft Word");
                            String filePath3 = "C:\\Program Files\\Microsoft Office\\root\\Office16\\WINWORD.EXE"; // Path to the application you want to launch

                            try {
                                File file = new File(filePath3);
                                Desktop.getDesktop().open(file);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case ("exit"):
                            voice.speak("It was very nice working with you i hope you liked my Assistance! THANK YOU SIR");
                            System.exit(0);

                        default:
                            voice.speak("Cannot Understand Please type again!");
                            System.out.println("Try again");
                    }
                }

    }
}