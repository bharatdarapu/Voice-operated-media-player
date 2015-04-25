import java.lang.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import javax.swing.event.*;
import javazoom.jl.player.Player;
import java.io.FileInputStream;
class skin22
{
Thread p;
JFrame jfr,pass,passfr;
int i=0,j=0,sl,m=1,co=1;
JLabel jlab;
boolean isplaying=false,op=false;
AbstractButton a;
boolean stopplay=false,single=false,pre=false,first=true,singplay=true;
FileInputStream fin1,fin2,fintheme,fintheme2;
BufferedReader br,themebr,themebr2;
String s10=null,themer=null,themer2,st,pl,plf,plf2;
String str[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"};
String str2[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"};
String theme[]={"1","2","3","4","5","6","7","8"};
String use="bharat";
String passme="bharat";
JTextField hinter;
JPasswordField passwd,pass1,pass2;
Player mp3;
JButton next,play,prev;

skin22()
{
try
{

fintheme2=new FileInputStream(".\\..\\Themes\\Current theme.txt");
themebr2=new BufferedReader(new InputStreamReader(fintheme2));
themer=themebr2.readLine();



fintheme=new FileInputStream(themer);
themebr=new BufferedReader(new InputStreamReader(fintheme));
while((s10=themebr.readLine())!=null)
{
theme[j++]=s10;
}
j=0;



plf=".\\..\\playlists\\default.txt";
fin1=new FileInputStream(".\\..\\Playlists\\default.txt");
br=new BufferedReader(new InputStreamReader(fin1));
while((s10=br.readLine())!=null)
{
str[i++]=s10;
}
i=0;

jfr=new JFrame("Media Player (mini)");
sl=str.length;
JMenuBar mbar=new JMenuBar();
//jfr.getContentPane().setBackground(Color.white);

JMenu file=new JMenu("File");
file.setFont(new Font("Papyrus",Font.BOLD,15));
JMenu playlist=new JMenu("Playlist");
playlist.setFont(new Font("Papyrus",Font.BOLD,15));
JMenu themes=new JMenu("Theme");
themes.setFont(new Font("Papyrus",Font.BOLD,15));
JMenu password=new JMenu("Password Protect");
password.setFont(new Font("Papyrus",Font.BOLD,15));

JMenuItem it1,it2,it3,it4,it5,it7,it8,it9,it10,it11,it12;


it1=new JMenuItem("Open");
it2=new JMenuItem("Close");
it3=new JMenuItem("view current Playlist");
it4=new JMenuItem("Edit Current Playlist as a text file");
it5=new JMenuItem("Create playlist");
JCheckBoxMenuItem it6=new JCheckBoxMenuItem("Play list mode",true);
it7=new JMenuItem("Add a song to the Current Playlist");
it5=new JMenuItem("Create playlist");
it8=new JMenuItem("Select playist");
it9=new JMenuItem("Delete Playlist");
it10=new JMenuItem("Select your Theme");
it11=new JMenuItem("Lock Player");
it12=new JMenuItem("Create a Password");



file.add(it1);
file.add(it2);

playlist.add(it6);
playlist.add(it8);
playlist.add(it3);
playlist.add(it4);
playlist.add(it7);
playlist.add(it5);
playlist.add(it9);

themes.add(it10);

password.add(it11);
password.add(it12);

mbar.add(file);
mbar.add(playlist);
mbar.add(themes);
mbar.add(password);

jfr.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(theme[j++])))));

jfr.setJMenuBar(mbar);
jfr.setLayout(new FlowLayout());
jfr.setSize(360,160);//500140
jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

ImageIcon next1=new ImageIcon(theme[j++]);
ImageIcon play1=new ImageIcon(theme[j++]);
ImageIcon prev1=new ImageIcon(theme[j++]);
ImageIcon stop1=new ImageIcon(theme[j++]);
ImageIcon pause1=new ImageIcon(theme[j++]);
ImageIcon close1=new ImageIcon(theme[j]);

next=new JButton(next1);
play=new JButton(play1);
prev=new JButton(prev1);
JButton stop=new JButton(stop1);
JButton pause=new JButton(pause1);
JButton close=new JButton(close1);
next.setPreferredSize(new Dimension(50,50));
play.setPreferredSize(new Dimension(50,50));
prev.setPreferredSize(new Dimension(50,50));
stop.setPreferredSize(new Dimension(50,50));
pause.setPreferredSize(new Dimension(50,50));
close.setPreferredSize(new Dimension(50,50));


it1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{ 
try
{
opened();
if(op==true)
{
if(isplaying==true)
mp3.close();
fin2=new FileInputStream(st);
mp3=new Player(fin2);
new play(mp3,fin2);
}
jlab.setText("Playing selected track");
}catch(Exception e)
{
System.out.println("caught in play opened");
}
}
});

it2.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
if(JOptionPane.showConfirmDialog(null, "Are You Sure Want To Exit? ","",JOptionPane.OK_CANCEL_OPTION)==0)
System.exit(0);
}
});

it3.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
viewplaylist();
}
});

it4.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
viewplaylist();
}
});

it5.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
try
{
createplaylist();
addsong();
if(op==true)
{
BufferedWriter brw=new BufferedWriter(new FileWriter(plf,true));
brw.write(pl);
brw.newLine();
brw.close();
}
}catch(Exception e)
{
System.out.println("Exception caught in add song it5");
}
}
});

it6.addItemListener(new ItemListener()
{
public void itemStateChanged(ItemEvent ie)
{
a=(AbstractButton)ie.getItem();
if(a.isSelected())
{
single=false;
jlab.setText("selected Playlist");
}
else
{
single=true;
jlab.setText("selected a single track");
}
}
});

it7.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
addsong();
try
{
BufferedWriter brw=new BufferedWriter(new FileWriter(plf,true));
brw.write(pl);
brw.newLine();
brw.close();
}catch(Exception e)
{
System.out.println("Exception caught in add song it7");
}
}
});

it8.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
selectplaylist();
}
});

it9.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
try
{
FileDialog fd =new FileDialog(new Frame(),"Edit Playlist...",FileDialog.LOAD);
fd.setFile("*.txt");
fd.setDirectory(".\\..\\Playlists");
fd.show();
pl=fd.getDirectory()+fd.getFile();
File f=new File(pl);
f.delete();
}catch(Exception e)
{
System.out.println("caught in delete playlist-it9");
}
}
});

it10.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
try
{
applytheme();
BufferedWriter brw=new BufferedWriter(new FileWriter(".\\..\\Themes\\Current theme.txt"));
brw.write(themer);
brw.close();
}catch(Exception e)
{
System.out.println("Exception caught in add song it7");
}
}
});



it11.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
jfr.setVisible(false);
pass=new JFrame("Enter the password to unlock");
pass.setDefaultCloseOperation(pass.DO_NOTHING_ON_CLOSE);
JButton ok=new JButton("Ok");
JButton hint=new JButton("Hint");
passwd= new JPasswordField(15);
pass.setLayout(new FlowLayout(FlowLayout.LEFT));
JLabel label2=new JLabel("Password:", SwingConstants.RIGHT);

pass.add(label2);
pass.add(passwd);
pass.add(ok);
pass.add(hint);
pass.setSize(300,100);
pass.setVisible(true);


ok.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent k)
{
String pack=new String(passwd.getPassword());
if(pack.equals(passme))
{
pass.dispose();
jfr.setVisible(true);
}
else
JOptionPane.showMessageDialog(null,"Incorrect password please try again","Password Verification",1);
}
});

hint.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent l)
{
JOptionPane.showMessageDialog(null,use,"Your hint is:",1);
}
});

}
});

it12.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
jfr.setVisible(false);
passfr=new JFrame("Enter the password");
passfr.setDefaultCloseOperation(passfr.DISPOSE_ON_CLOSE);
JButton ok=new JButton("Ok");
pass1=new JPasswordField(10);
pass2= new JPasswordField(10);
hinter=new JTextField(15);
passfr.setLayout(new FlowLayout(FlowLayout.LEFT));
JLabel label=new JLabel("password:", SwingConstants.RIGHT);
JLabel label2=new JLabel("reenter Password:", SwingConstants.RIGHT);
JLabel label3=new JLabel("Enter the Hint:", SwingConstants.RIGHT);

passfr.add(label);
passfr.add(pass1);
passfr.add(label2);
passfr.add(pass2);
passfr.add(label3);
passfr.add(hinter);
passfr.add(ok);
passfr.setSize(300,150);
passfr.setVisible(true);


passfr.addWindowListener(new WindowAdapter()
{
public void windowClosed(WindowEvent we)
{
jfr.setVisible(true);
}
});


ok.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent k)
{
String pack1=new String(pass1.getPassword());
String pack2=new String(pass2.getPassword());
if(pack1.equals(pack2))
{
passme=pack1;
String pack3=hinter.getText();
use=pack3;
passfr.dispose();
jfr.setVisible(true);
}
else
JOptionPane.showMessageDialog(null,"passwords do not match","passwd",1);
}
});

}
});


next.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
try
{
stopplay=false;

singplay=true;
if(single==true)
{
if(isplaying==true)
mp3.close();
fin2=new FileInputStream(st);
mp3=new Player(fin2);
new play(mp3,fin2);
jlab.setText("Playing Selected Track");
}
else
{
if(isplaying==true)
mp3.close();
if(i<sl)
{
fin2=new FileInputStream(str[++i]);
mp3=new Player(fin2);
new play(mp3,fin2);
jlab.setText("Playing Track:"+(i+1));
}
else
{
i=0;
fin2=new FileInputStream(str[i]);
mp3=new Player(fin2);
new play(mp3,fin2);
jlab.setText("Playing Track:"+(i+1));
}
}

}catch(Exception e)
{
System.out.println("caught in next button");
}
}
});

play.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
try
{
if(i<0)
i=0;
if(co>1)
{
singplay=false;
stopplay=false;
}
if(single==true)
{
if(isplaying==true)
mp3.close();
fin2=new FileInputStream(st);
mp3=new Player(fin2);
new play(mp3,fin2);
jlab.setText("Playing selected track");
}
else
{
if(isplaying==true)
mp3.close();
fin2=new FileInputStream(str[i]);
mp3=new Player(fin2);
jlab.setText("Playing playlist track:"+(i+1));
new play(mp3,fin2);
}
}catch(Exception e)
{
System.out.println("caught in play button");
}
}
});


prev.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
try
{
stopplay=false;
pre=true;
singplay=true;
if(single==true)
{
if(isplaying==true)
mp3.close();
fin2=new FileInputStream(st);
mp3=new Player(fin2);
new play(mp3,fin2);
jlab.setText("Playing Selected Track");
}
else
{
if(isplaying==true)
mp3.close();
if(i>=0)
{
fin2=new FileInputStream(str[--i]);
mp3=new Player(fin2);
new play(mp3,fin2);
jlab.setText("Playing Track:"+(i+1));
}
else
{
fin2=new FileInputStream(str[i]);
mp3=new Player(fin2);
new play(mp3,fin2);
jlab.setText("Playing Track:"+(i+1));
}
}
}catch(Exception e)
{
System.out.println("caught in previous button");
}
}
});

stop.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{ 
pre=false;
co=1;
stopplay=true;
if(isplaying==true )
{
mp3.close();
isplaying=false;
}
jlab.setText("STOPPED");
}
});

close.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
try
{
if(JOptionPane.showConfirmDialog(null, "Are You Sure Want To Exit? ","",JOptionPane.OK_CANCEL_OPTION)==0)
System.exit(0);
}catch(Exception e)
{
System.out.println("caughtin close button");
}
}
});

pause.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
try
{
System.out.println("pause/resume in progress");
}catch(Exception e)
{
System.out.println("caughtin close button");
}
}
});

jfr.add(next);
jfr.add(play);
jfr.add(prev);
jfr.add(pause);
jfr.add(stop);
jfr.add(close);
jlab=new JLabel("Press A button",JLabel.CENTER);
jlab.setFont(new Font("Papyrus",Font.BOLD,15));

jlab.setForeground(Color.white);
jfr.add(jlab);
jfr.setVisible(true);
}catch(Exception e)
{
System.out.println("caught in frame declaration");
}
}

public static void main(String args[])
{
SwingUtilities.invokeLater(new Runnable()
{
public void run()
{
new skin22();
}
});
}



class play implements Runnable
{
Thread p2;
play(Player mp3,FileInputStream fin2)
{
isplaying=true;
p=new Thread(this,"Playing");
p.start();
}
public void run()
{
try
{
co++;
mp3.play();
if(stopplay==false&&pre==false&&singplay==true&&op==false&&co>=2)
next.doClick();
else if(pre==true&&singplay==true&&op==false)
{
prev.doClick();
pre=false;
}
else if(stopplay==false&&singplay==false&&op==false)
play.doClick();
else if(stopplay==false&&single==true&&op==true)
play.doClick();
}catch(Exception e)
{
System.out.println("caught in play thread");
}
}
}


void opened()
{
FileDialog fd = new FileDialog(new Frame(),"open..", FileDialog.LOAD);
fd.setFile("*.mp3");
fd.setDirectory(".\\");
fd.show();
st=fd.getDirectory()+fd.getFile();
if(st.equals(".\\null"))
op=false;
else
op=true;
}


void createplaylist()
{
try
{
co=1;
i=0;
stopplay=false;
singplay=true;
while(true)
{
File fk=new File(".\\..\\Playlists\\playlist"+m+".txt");
if(fk.exists())
{
++m;
}
else
break;
}
FileWriter fo=new FileWriter(".\\..\\Playlists\\playlist"+m+".txt");
plf=".\\..\\Playlists\\playlist"+m+".txt";
fo.close();
}catch(Exception e)
{
System.out.println("caught in create playlist");
}
}



void addsong()
{
FileDialog fd =new FileDialog(new Frame(),"Add a Song...",FileDialog.LOAD);
fd.setFile("*.mp3");
fd.setDirectory(".\\");
fd.show();
pl=fd.getDirectory()+fd.getFile();
}

void selectplaylist()
{
try
{
co=1;
i=0;
plf2=plf;
stopplay=false;
singplay=true;
FileDialog fd = new FileDialog(new Frame(),"open..", FileDialog.LOAD);
fd.setFile("*.txt");
fd.setDirectory(".\\..\\Playlists");
fd.show();
plf=fd.getDirectory()+fd.getFile();
if(plf.equals(".\\..\\Playlistsnull"))
plf=plf2;
fin1=new FileInputStream(plf);
br=new BufferedReader(new InputStreamReader(fin1));
while((s10=br.readLine())!=null)
{
str[i++]=s10;
}
while(i<sl)
str[i++]="1";
i=0;
br.close();
}catch(Exception e)
{
System.out.println("caught in selectplaylist");
}
}

void viewplaylist()
{
try
{
Runtime runtime = Runtime.getRuntime();
Process proc = null;
proc = runtime.exec("C:\\Windows\\notepad.exe "+plf);
}catch(Exception e)
{
System.out.println("caught in view playlist");
}
}


void applytheme()
{
themer2=themer;
FileDialog fd = new FileDialog(new Frame(),"open..", FileDialog.LOAD);
fd.setFile("*.txt");
fd.setDirectory(".\\..\\Themes");
fd.show();
themer=fd.getDirectory()+fd.getFile();
if(themer.equals(".\\..\\Themesnull"))
themer=themer2;
else
JOptionPane.showMessageDialog(null,"Your Theme will be applied the next time you start the player","Apply Theme",1);
}
}