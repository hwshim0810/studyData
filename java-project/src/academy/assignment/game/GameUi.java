package academy.assignment.game;

/**
 * @author Shim Hyun-Woo
 * @Created 2016.11
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants; 

class GameUi implements GameInterface {
	static JLabel lbMyScore = new JLabel(String.valueOf(GameCore.myScore) + " 점", SwingConstants.CENTER);
	static JLabel lbComScore = new JLabel(String.valueOf(GameCore.computerScore) + " 점", SwingConstants.CENTER);
	static JLabel lbPlayCount = new JLabel(String.valueOf(GameCore.playCount) + " 번", SwingConstants.CENTER);
	static JLabel icMyHand = new JLabel();
	static JLabel icComHand = new JLabel();
	static JLabel lbGameResult = new JLabel("", SwingConstants.CENTER);
	static boolean flag = true;
	static Clip clip2 = null;
	
	public void setIcon(BufferedImage[] handIcons, JButton[] jlIcons, ActionListener al, MouseListener ml) {
		for(int i = 0; i < handIcons.length; i++) {
			jlIcons[i].setIcon(new ImageIcon(handIcons[i]));
			jlIcons[i].setFocusPainted(false);
//			jlIcons[i].setContentAreaFilled(false);
			jlIcons[i].addActionListener(al);
			jlIcons[i].addMouseListener(ml);
		}
	}	
	
	public void init() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
		//frameAndIconDefine
		JFrame frame = new JFrame("paper-scissors-stone Game");
		ImageIcon img = new ImageIcon("./img/frameIcon.png");
		
		BufferedImage[] handIcons = { ImageIO.read(new File("./img/scissor.png")),
				ImageIO.read(new File("./img/rock.png")), ImageIO.read(new File("./img/cloth.png"))};
		JButton[] jlIcons = new JButton[3];
		
		//frameConfig
		frame.setIconImage(img.getImage());
		frame.setSize(900, 700);		frame.setVisible(true);
		frame.setResizable(false);		frame.setLocation(450, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container ct = frame.getContentPane();
		ct.setLayout(new BorderLayout());
		
		//fontPart
		Font fontSumScore = new Font("굴림", Font.BOLD + Font.ITALIC, 16);
		Font fontNowScore = new Font("굴림", Font.BOLD + Font.ITALIC, 18);
		Font fontBtn = new Font("굴림", Font.BOLD, 25);
		
		//bgmPart
        File music = new File("./music/SKRILLEX - Scary Monsters And Nice Sprites.wav");
		Clip clip = AudioSystem.getClip();
		AudioInputStream ais = AudioSystem.getAudioInputStream(music);
		clip.open(ais);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
		//menuBarDefine
		JMenuBar jmb = new JMenuBar();
		
		JMenu jmu1 = new JMenu("File");
		JCheckBoxMenuItem jmu1Item1 = new JCheckBoxMenuItem("Music Stop", false);		jmu1.add(jmu1Item1);
		jmu1Item1.addItemListener(ie -> {
			if (ie.getStateChange() == 1) clip.stop();
			else clip.start();
		});
		
		jmu1.addSeparator();
		
		JMenuItem jmu1Item2 = new JMenuItem("Exit");		jmu1.add(jmu1Item2);
		jmu1Item2.addActionListener(ae -> {
			System.exit(0);
		});
		
		JMenu jmu2 = new JMenu("Help");
		JMenuItem jmu2Item1 = new JMenuItem("About");	jmu2.add(jmu2Item1);
		jmu2Item1.addActionListener(ae -> {
				String msg = "게임시작 버튼을 클릭하면 게임을 시작할 수 있습니다.\n" +"게임의 결과는 바로 상단의 점수바에 반영됩니다.\n"
						+ "그만하기 버튼을 클릭하면 최종결과 출력 후\n" + "프로그램을 종료합니다.\n" +"만든이 : 심현우";
				JOptionPane.showMessageDialog(frame, msg, "About", JOptionPane.INFORMATION_MESSAGE);
		
		});
		
		jmb.add(jmu1);	jmb.add(jmu2);
		
		//panelDefine
		Panel pnSumScoreBoard = new Panel(new GridLayout(1, 7));
		Panel pnMainDisplay = new Panel(new BorderLayout());
		Panel pnStart = new Panel(new BorderLayout());
		Panel pnGameDisplay = new Panel(new GridLayout(1, 3));
		Panel pnNowScoreBoard = new Panel(new GridLayout(1, 6));
		Panel pnMenu = new Panel(new BorderLayout());
		pnGameDisplay.setBackground(Color.black);
		pnNowScoreBoard.setBackground(Color.WHITE);
		pnMenu.setBackground(Color.WHITE);
		
		//mouseAndActionEvent
		class mouseEvent extends MouseAdapter {
			public void mouseEntered(MouseEvent me) {
				me.getComponent().setBackground(Color.WHITE);
			}
			public void mouseExited(MouseEvent me) {
				me.getComponent().setBackground(Color.BLACK);
			}
		}
		mouseEvent meIns = new mouseEvent();
		
		ActionListener al = e -> {
			int myHand = Integer.valueOf(e.getActionCommand());
			int gameResult = GameCore.getZeroToRange(3);
			int comHand = GameCore.printResult(myHand, gameResult);
			
			lbMyScore.setText(String.valueOf(GameCore.myScore) + " 점");
			lbComScore.setText(String.valueOf(GameCore.computerScore) + " 점");
			lbPlayCount.setText(String.valueOf(GameCore.playCount) + " 회");
			lbGameResult.setText(GameCore.gameResults[gameResult]);
			icMyHand.setIcon(new ImageIcon(handIcons[myHand].getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
			icComHand.setIcon(new ImageIcon(handIcons[comHand].getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
			
			try {
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./music/click.wav").getAbsoluteFile());
	            clip2 = AudioSystem.getClip();
	            clip2.open(audioInputStream);
	            clip2.start();
			} catch (Exception aue) {
				aue.printStackTrace();
			}
		};
		
		//upperPanel
		JLabel lbSumMy = new JLabel("나의 점수 : ", SwingConstants.CENTER);
		JLabel lbSumCom = new JLabel("컴퓨터의 점수 : ", SwingConstants.CENTER);
		JLabel lbGameCount = new JLabel("게임횟수 : ", SwingConstants.CENTER);
		
		lbSumMy.setFont(fontSumScore);	lbSumMy.setForeground(Color.BLUE);
		lbSumCom.setFont(fontSumScore);
		lbGameCount.setFont(fontSumScore);
		lbMyScore.setFont(fontSumScore);	lbMyScore.setForeground(Color.BLUE);
		lbComScore.setFont(fontSumScore);
		lbPlayCount.setFont(fontSumScore);
		
		pnSumScoreBoard.add(lbSumMy);
		pnSumScoreBoard.add(lbMyScore);
		pnSumScoreBoard.add(lbSumCom);
		pnSumScoreBoard.add(lbComScore);
		pnSumScoreBoard.add(lbGameCount);
		pnSumScoreBoard.add(lbPlayCount);
		
		//centerIcon
		for(int i = 0; i < jlIcons.length; i++) 
			pnGameDisplay.add(jlIcons[i] = new JButton(i + ""), BorderLayout.CENTER);
		
		for(int i = 0; i < jlIcons.length; i++) {
			jlIcons[i].setIcon(new ImageIcon(handIcons[i]));
			jlIcons[i].setFocusPainted(false);
//			jlIcons[i].setContentAreaFilled(false);
			jlIcons[i].setBackground(Color.BLACK);
		}
		
		//middleUnder btn
		JButton btnStart = new JButton("게임 시작");
		
		btnStart.setFont(fontBtn);		btnStart.setFocusPainted(false);
		btnStart.setContentAreaFilled(false);
		btnStart.addActionListener(ae -> {
			flag = false;
			btnStart.setVisible(false);
			setIcon(handIcons, jlIcons, al, meIns);
		});
	
		JButton btnExit = new JButton("그만 하기");
		
		btnExit.setBackground(Color.BLACK);	btnExit.setForeground(Color.WHITE);
		btnExit.setFont(fontBtn);	btnExit.setFocusPainted(false);
		btnExit.addActionListener(ae -> {
			String msg = "";
			
			if (GameCore.playCount == 0) msg = " >>> 게임이 이루어지지 않았습니다 <<<";
			else if (GameCore.myScore > GameCore.computerScore)
				msg = "당신의 점수 : " + GameCore.myScore + " 컴퓨터의 점수 : " + GameCore.computerScore 
				+ "\n   >>> 당신이 " + GameCore.gameResults[1] + " <<< ";
			else if (GameCore.myScore < GameCore.computerScore)
				msg = "당신의 점수 : " + GameCore.myScore + " 컴퓨터의 점수 : " + GameCore.computerScore 
				+ "\n   >>> 당신이 " + GameCore.gameResults[2] + " <<< ";
			else
				msg = "당신의 점수 : " + GameCore.myScore + " 컴퓨터의 점수 : " + GameCore.computerScore 
				+ "\n   >>> 당신은 " + GameCore.gameResults[0] + " <<< ";
			
			JOptionPane.showMessageDialog(frame, msg, "Game Result", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		});
		
		//underPanel
		JLabel lbMyHand = new JLabel("내가 낸것 : ", SwingConstants.CENTER);		
		JLabel lbComHand = new JLabel("컴퓨터가 낸것 : ", SwingConstants.CENTER);
	
		lbMyHand.setFont(fontNowScore);		lbComHand.setFont(fontNowScore);
		lbMyHand.setForeground(Color.BLUE);
		lbGameResult.setFont(fontNowScore);	lbGameResult.setForeground(Color.BLUE);
		
		pnNowScoreBoard.add(lbMyHand);
		pnNowScoreBoard.add(icMyHand);
		pnNowScoreBoard.add(lbComHand);
		pnNowScoreBoard.add(icComHand);
		pnNowScoreBoard.add(lbGameResult);
		pnNowScoreBoard.add(btnExit);
		
		//allPanel attach
		pnStart.add(btnStart);
		pnMainDisplay.add(pnGameDisplay, BorderLayout.CENTER);
		pnMainDisplay.add(pnStart, BorderLayout.SOUTH);
		pnMenu.add(jmb, BorderLayout.NORTH);
		pnMenu.add(pnSumScoreBoard, BorderLayout.SOUTH);
		
		ct.add(pnMenu, BorderLayout.NORTH);
		ct.add(pnMainDisplay, BorderLayout.CENTER);
		ct.add(pnNowScoreBoard, BorderLayout.SOUTH);
		
		//initDisplay
		int i = 0;
		while (flag) {
			jlIcons[0].setIcon(new ImageIcon(handIcons[(i+1) % 3]));
			jlIcons[1].setIcon(new ImageIcon(handIcons[(i+2) % 3]));
			jlIcons[2].setIcon(new ImageIcon(handIcons[(i+3) % 3]));
			++i;
			try {
				Thread.sleep(200);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	
	}
}
