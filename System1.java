package 餐厅点餐系统;

import java.awt.*;
 
import javax.sql.rowset.WebRowSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Calendar;
import java.util.Date;
import java.io.*;
import java.net.NoRouteToHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
//事件处理包
import java.awt.event.*;
 
public class System1 implements ActionListener{
//北部区域
	JMenuBar jm1=new JMenuBar();
    private JLabel jl1;
    
//南部区域
    private JButton jb1, jb2, jb3, jb4 , jb5;
    private JPanel jp1;    
    
//西部区域
    private JTabbedPane jtp2;
    private JPanel jp8;
    private JButton jb6, jb7, jb8, jb9, jb10, jb11;
    
//东部区域   
    private JPanel jp9;
    private JComboBox jcb11;
    private JLabel jl20, jl21, jl22;
    private JTextField jtf2;
    private JTable jt;
    private JScrollPane jsp;
    
    String[] jg = { "桌1", "桌2", "桌3", "桌4", "桌5", "桌6" };
    private DefaultTableModel model;
    private Vector data;
    private Vector names;
    
//中部区域
    private JTabbedPane jtp;// 选项卡窗格
    private ImageIcon img;
    private JPanel jp2, jp3, jp4, jp5, jp6, jp7;    
    private JLabel jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9, jl10, jl11, jl12, jl13, jl14, jl15, jl16, jl17, jl18, jl19;
    private JCheckBox jcb1, jcb2, jcb3, jcb4, jcb5, jcb6, jcb7, jcb8, jcb9;
//判断
    boolean B = true;
//文件输出
    BufferedWriter out;
//主框架
    JFrame jf;
 	public void init(String username) {
	//北部区域
		jl1 = new JLabel("*****课设餐厅欢迎您*****",JLabel.CENTER);
		jl1.setOpaque(true);//设置背景颜色必须先将它设置为不透明的，因为默认是透明的。
		jl1.setBackground(Color.pink);
		Font f = new Font("楷体",Font.PLAIN,45); 
		jl1.setFont(f);
		jl1.setForeground(Color.BLUE);
	    
		JMenu menu1=new JMenu("系统设置");	
    	jm1.add(menu1);
	    
    	JMenu menu2=new JMenu("餐厅名称字体");      
    	JMenu menu3=new JMenu("餐厅名称颜色");	        
    	JMenuItem item9=new JMenuItem("退出登录");	       	             
    	menu1.add(menu2);
    	menu1.add(menu3);
    	menu1.addSeparator();
    	menu1.add(item9);
	//设置监听退出登录
        item9.addActionListener(new ActionListener() {	            
            @Override
            public void actionPerformed( ActionEvent e) {
                int i=JOptionPane.showConfirmDialog(null, "是否退出登录","退出登录",JOptionPane.YES_NO_OPTION);       
                if(i == JOptionPane.YES_OPTION) {                     	                
                	jf.setVisible(false);
                	new Land().init();
                }
            }
        });
	//菜单栏设置标题字体
        JMenuItem item1=new JMenuItem("楷体");	                
        JMenuItem item2=new JMenuItem("宋体");	                
        JMenuItem item3=new JMenuItem("黑体");	                	        
        JMenuItem item4=new JMenuItem("正文");
        menu2.add(item1);
        menu2.add(item2);
        menu2.add(item3);	       
        menu2.add(item4);
        
        item1.addActionListener(new ActionListener() {       	
        	public void actionPerformed( ActionEvent e) {
        		Font f = new Font("楷体",Font.PLAIN,45);
        		jl1.setFont(f);
                }           
        });
        item2.addActionListener(new ActionListener() {       	
        	public void actionPerformed( ActionEvent e) {
        		Font f = new Font("宋体",Font.PLAIN,45);
        		jl1.setFont(f);
                }           
        });
        item3.addActionListener(new ActionListener() {        	
        	public void actionPerformed( ActionEvent e) {
        		Font f = new Font("黑体",Font.PLAIN,45);
        		jl1.setFont(f);
                }           
        });
        item4.addActionListener(new ActionListener() {        	
        	public void actionPerformed( ActionEvent e) {
        		Font f = new Font("正文",Font.PLAIN,45);
        		jl1.setFont(f);
                }           
        });
	//菜单栏设置标题颜色                      
        JMenuItem item5=new JMenuItem("蓝色");	                
        JMenuItem item6=new JMenuItem("红色");	                	        
        JMenuItem item7=new JMenuItem("黑色");	            
        JMenuItem item8=new JMenuItem("绿色");
        menu3.add(item5);
        menu3.add(item6);
        menu3.add(item7);	       
        menu3.add(item8);
        
        item5.addActionListener(new ActionListener() {       	
        	public void actionPerformed( ActionEvent e) {
        		jl1.setForeground(Color.BLUE);
                }           
        });
        item6.addActionListener(new ActionListener() {        	
        	public void actionPerformed( ActionEvent e) {
        		jl1.setForeground(Color.RED);
                }           
        });
        item7.addActionListener(new ActionListener() {        	
        	public void actionPerformed( ActionEvent e) {
        		jl1.setForeground(Color.BLACK);
                }           
        });
        item8.addActionListener(new ActionListener() {       	
        	public void actionPerformed( ActionEvent e) {
        		jl1.setForeground(Color.green);
                }           
        });
        
	//南部区域
	    jp1 = new JPanel();
	    jb1 = new JButton("取消");
	    jb2 = new JButton("下单");
	    jb3 = new JButton("加单");
	    jb4 = new JButton("结账");
 
	//西部区域
	    jtp2 = new JTabbedPane();
	    jp8 = new JPanel();    	    
	    jb6 = new JButton("热销菜式");
	    jb7 = new JButton("小炒类");	    
	    jb8 = new JButton("蔬菜类");	    
	    jb9 = new JButton("主食类");	    
	    jb10 = new JButton("甜品类");	
	    jb11 = new JButton("饮品类");
	    	    	    
	//东部区域
	    jp9 = new JPanel();
	    jl20 = new JLabel("请选择桌号：");	    
	    jcb11 = new JComboBox(jg);
	    jl21 = new JLabel("请输入用餐人数：");
	    jtf2 = new JTextField();
	    jl22 = new JLabel("已点菜式列表：");	
	    
	    model = new DefaultTableModel(); // 新建一个默认数据模型
	    data = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
	    names = new Vector();// 列名向量，使用它的add()方法添加列名
	    names.add("菜名");	
	    names.add("价格（元）");    
	    model.setDataVector(data,names); // 设置模型中的元素，它会自动显示在列表中
	    jt = new JTable(model); // 用数据模型创建JTable，JTable会自动监听到数据模型中的数据改变并显示出来
	    jsp = new JScrollPane(jt); // 用列表创建可滚动的Panel，把这个Panel添加到窗口中	   	  
	    
	//中部区域
	    jtp = new JTabbedPane();
	    
	    img=new ImageIcon("主食类//红烧肉.jpg");//创建一个图标       
        jl2 = new JLabel(img);      
        img=new ImageIcon("主食类//红烧猪蹄.jpg");          
        jl3 = new JLabel(img);
        img=new ImageIcon("主食类//家常炒面.jpg");          
        jl4 = new JLabel(img);
        img=new ImageIcon("小炒类//家常小炒.jpg");           
        jl5 = new JLabel(img);
        img=new ImageIcon("小炒类//木须肉.jpg");          
        jl6 = new JLabel(img);
        img=new ImageIcon("小炒类//小炒圆白菜.jpg");          
        jl7 = new JLabel(img);
        img=new ImageIcon("蔬菜类//苦瓜炒蛋.jpg");           
        jl8 = new JLabel(img);
        img=new ImageIcon("蔬菜类//炒四季豆.jpg");          
        jl9 = new JLabel(img);
        img=new ImageIcon("蔬菜类//凉拌土豆丝.jpg");          
        jl10 = new JLabel(img);
        
        jl11 = new JLabel("39",JLabel.CENTER);
        jl12 = new JLabel("39",JLabel.CENTER);
        jl13 = new JLabel("39",JLabel.CENTER);
        jl14 = new JLabel("28",JLabel.CENTER);
        jl15 = new JLabel("28",JLabel.CENTER);
        jl16 = new JLabel("28",JLabel.CENTER);
        jl17 = new JLabel("18",JLabel.CENTER);
        jl18 = new JLabel("18",JLabel.CENTER);
        jl19 = new JLabel("18",JLabel.CENTER);
        
        jcb1 = new JCheckBox("红烧肉");
	    jcb2 = new JCheckBox("红烧猪蹄");
	    jcb3 = new JCheckBox("家常炒面");
	    jcb4 = new JCheckBox("家常小炒");
	    jcb5 = new JCheckBox("木须肉");
	    jcb6 = new JCheckBox("小炒圆白菜");
	    jcb7 = new JCheckBox("苦瓜炒蛋");
	    jcb8 = new JCheckBox("炒四季豆");
	    jcb9 = new JCheckBox("凉拌土豆丝");
	    
	    jp2 = new JPanel();	            
	    jp3 = new JPanel();	   
	    jp4 = new JPanel();	    
	    jp5 = new JPanel();
	    jp6 = new JPanel();
	    jp7 = new JPanel();
 
	//将面板添加到选项卡窗格上
	    jtp.add("热销菜式", jp2);
	    jtp.add("小炒类", jp3);
	    jtp.add("蔬菜类", jp4);
	    jtp.add("主食类", jp5);
	    jtp.add("甜品类", jp6);
	    jtp.add("饮品类", jp7);
 
	    jtp2.add("菜式导航", jp8);
	    
	//设置布局	   	    
	    jp2.setLayout(new GridLayout(9,3));
	    jp3.setLayout(new GridLayout(9,3));
	    jp4.setLayout(new GridLayout(9,3));
	    jp5.setLayout(new GridLayout(9,3));
	    jp6.setLayout(new GridLayout(9,3));
	    jp7.setLayout(new GridLayout(9,3));
	    jp8.setLayout(new GridLayout(15,1));
	    jp9.setLayout(new GridLayout(6,1));	
	    
	    jp9.setPreferredSize(new Dimension(250, 0));   	     
 
	//指定action 命令 
	    jb1.addActionListener(this);
	    jb1.setActionCommand("取消");
	    jb2.addActionListener(this);
	    jb2.setActionCommand("下单");
	    jb3.addActionListener(this);
	    jb3.setActionCommand("加单");
	    jb4.addActionListener(this);
	    jb4.setActionCommand("结账");	   
	    jb6.addActionListener(this);
	    jb6.setActionCommand("热销菜式");
	    jb7.addActionListener(this);
	    jb7.setActionCommand("小炒类");
	    jb8.addActionListener(this);
	    jb8.setActionCommand("蔬菜类");
	    jb9.addActionListener(this);
	    jb9.setActionCommand("主食类");
	    jb10.addActionListener(this);
	    jb10.setActionCommand("甜品类");
	    jb11.addActionListener(this);
	    jb11.setActionCommand("饮品类");
	    
	//添加组件
	    jp1.add(jb1);
	    jp1.add(jb2);
	    jp1.add(jb3);
	    jp1.add(jb4);
 
	    jp2.add(jl2);
	    jp2.add(jl3);
	    jp2.add(jl4);
	    jp2.add(jl11);
	    jp2.add(jl12);
	    jp2.add(jl13);	    
	    jp2.add(jcb1);	   
	    jp2.add(jcb2);	    
	    jp2.add(jcb3);	    
	    jp2.add(jl5);
	    jp2.add(jl6);
	    jp2.add(jl7);
	    jp2.add(jl14);
	    jp2.add(jl15);
	    jp2.add(jl16);
	    jp2.add(jcb4);				
	    jp2.add(jcb5);		
	    jp2.add(jcb6);
	    jp2.add(jl8);
	    jp2.add(jl9);
	    jp2.add(jl10);
	    jp2.add(jl17);
	    jp2.add(jl18);
	    jp2.add(jl19);
	    jp2.add(jcb7);				
	    jp2.add(jcb8);		
	    jp2.add(jcb9);
	    	    
	 	jp8.add(jb6);
	    jp8.add(jb7);
	    jp8.add(jb8);
	    jp8.add(jb9);
	    jp8.add(jb10);
	    jp8.add(jb11);
	    
	    jp9.add(jl20);
	    jp9.add(jcb11);
	    jp9.add(jl21);
	    jp9.add(jtf2);
	    jp9.add(jl22);
	    jp9.add(jsp);
	    
	//续中部区域
	//小炒类
	    img=new ImageIcon("小炒类//豆角炒腊肉.jpg");      
        jl2 = new JLabel(img);      
        img=new ImageIcon("小炒类//家常小炒.jpg");          
        jl3 = new JLabel(img);
        img=new ImageIcon("小炒类//木须肉.jpg");          
        jl4 = new JLabel(img);
	    img=new ImageIcon("小炒类//农家小炒肉.jpg");           
        jl5 = new JLabel(img);
        img=new ImageIcon("小炒类//四季豆小炒肉.jpg");          
        jl6 = new JLabel(img);
        img=new ImageIcon("小炒类//小炒牛肉.jpg");          
        jl7 = new JLabel(img);
        img=new ImageIcon("小炒类//小炒香菇黄瓜条.jpg");           
        jl8 = new JLabel(img);
        img=new ImageIcon("小炒类//小炒圆白菜.jpg");          
        jl9 = new JLabel(img);
        img=new ImageIcon();          
        jl10 = new JLabel(img);        
        
        jl11 = new JLabel("28",JLabel.CENTER);
        jl12 = new JLabel("28",JLabel.CENTER);
        jl13 = new JLabel("28",JLabel.CENTER);
        jl14 = new JLabel("28",JLabel.CENTER);
        jl15 = new JLabel("28",JLabel.CENTER);
        jl16 = new JLabel("28",JLabel.CENTER);
        jl17 = new JLabel("28",JLabel.CENTER);
        jl18 = new JLabel("28",JLabel.CENTER);
        jl19 = new JLabel("",JLabel.CENTER);
        
        jcb1 = new JCheckBox("豆角炒腊肉");
	    jcb2 = new JCheckBox("家常小炒");
	    jcb3 = new JCheckBox("木须肉");
	    jcb4 = new JCheckBox("农家小炒肉");
	    jcb5 = new JCheckBox("四季豆小炒肉");
	    jcb6 = new JCheckBox("小炒牛肉");
	    jcb7 = new JCheckBox("小炒香菇黄瓜条");
	    jcb8 = new JCheckBox("小炒圆白菜");	    	    
	    
	    jp3.add(jl2);
	    jp3.add(jl3);
	    jp3.add(jl4);
	    jp3.add(jl11);
	    jp3.add(jl12);
	    jp3.add(jl13);
	    jp3.add(jcb1);				
	    jp3.add(jcb2);		
	    jp3.add(jcb3);
	    jp3.add(jl5);
	    jp3.add(jl6);
	    jp3.add(jl7);
	    jp3.add(jl14);
	    jp3.add(jl15);
	    jp3.add(jl16);
	    jp3.add(jcb4);				
	    jp3.add(jcb5);		
	    jp3.add(jcb6);
	    jp3.add(jl8);	    
	    jp3.add(jl9);
	    jp3.add(jl10);
	    jp3.add(jl17);
	    jp3.add(jl18);
	    jp3.add(jl19);
	    jp3.add(jcb7);				
	    jp3.add(jcb8);
	//蔬菜类
	    img=new ImageIcon("蔬菜类//炒四季豆.jpg");      
        jl2 = new JLabel(img);      
        img=new ImageIcon("蔬菜类//苦瓜炒蛋.jpg");          
        jl3 = new JLabel(img);
        img=new ImageIcon("蔬菜类//凉拌土豆丝.jpg");          
        jl4 = new JLabel(img);
	    img=new ImageIcon("蔬菜类//茄子肉末.jpg");           
        jl5 = new JLabel(img);
        img=new ImageIcon("蔬菜类//豌豆炒鸡米.jpg");          
        jl6 = new JLabel(img);
        img=new ImageIcon("蔬菜类//虾酱荷兰豆.jpg");          
        jl7 = new JLabel(img);
        img=new ImageIcon("蔬菜类//腰果玉米.jpg");           
        jl8 = new JLabel(img);
        img=new ImageIcon();          
        jl9 = new JLabel(img);
        img=new ImageIcon();          
        jl10 = new JLabel(img);        
        
        jl11 = new JLabel("18",JLabel.CENTER);
        jl12 = new JLabel("18",JLabel.CENTER);
        jl13 = new JLabel("18",JLabel.CENTER);
        jl14 = new JLabel("18",JLabel.CENTER);
        jl15 = new JLabel("18",JLabel.CENTER);
        jl16 = new JLabel("18",JLabel.CENTER);
        jl17 = new JLabel("18",JLabel.CENTER);
        jl18 = new JLabel("",JLabel.CENTER);
        jl19 = new JLabel("",JLabel.CENTER);       
        
        jcb1 = new JCheckBox("炒四季豆");
	    jcb2 = new JCheckBox("苦瓜炒蛋");
	    jcb3 = new JCheckBox("凉拌土豆丝");
	    jcb4 = new JCheckBox("茄子肉末");
	    jcb5 = new JCheckBox("豌豆炒鸡米");
	    jcb6 = new JCheckBox("虾酱荷兰豆");
	    jcb7 = new JCheckBox("腰果玉米");	    	    	    
	    
	    jp4.add(jl2);
	    jp4.add(jl3);
	    jp4.add(jl4);
	    jp4.add(jl11);
	    jp4.add(jl12);
	    jp4.add(jl13);
	    jp4.add(jcb1);				
	    jp4.add(jcb2);		
	    jp4.add(jcb3);
	    jp4.add(jl5);
	    jp4.add(jl6);
	    jp4.add(jl7);
	    jp4.add(jl14);
	    jp4.add(jl15);
	    jp4.add(jl16);
	    jp4.add(jcb4);				
	    jp4.add(jcb5);		
	    jp4.add(jcb6);
	    jp4.add(jl8);	    
	    jp4.add(jl9);
	    jp4.add(jl10);
	    jp4.add(jl17);
	    jp4.add(jl18);
	    jp4.add(jl19);
	    jp4.add(jcb7);				
	//主食类
	    img=new ImageIcon("主食类//红烧肉.jpg");      
        jl2 = new JLabel(img);      
        img=new ImageIcon("主食类//红烧猪蹄.jpg");          
        jl3 = new JLabel(img);
        img=new ImageIcon("主食类//家常炒面.jpg");          
        jl4 = new JLabel(img);
	    img=new ImageIcon("主食类//金牌海鲜炒饭.jpg");           
        jl5 = new JLabel(img);
        img=new ImageIcon("主食类//糖醋排骨.jpg");          
        jl6 = new JLabel(img);
        img=new ImageIcon("主食类//新奥尔良烤翅.jpg");          
        jl7 = new JLabel(img);
        img=new ImageIcon("主食类//照烧鸡腿.jpg");           
        jl8 = new JLabel(img);
        img=new ImageIcon();          
        jl9 = new JLabel(img);
        img=new ImageIcon();          
        jl10 = new JLabel(img);        
        
        jl11 = new JLabel("39",JLabel.CENTER);
        jl12 = new JLabel("39",JLabel.CENTER);
        jl13 = new JLabel("39",JLabel.CENTER);
        jl14 = new JLabel("39",JLabel.CENTER);
        jl15 = new JLabel("39",JLabel.CENTER);
        jl16 = new JLabel("39",JLabel.CENTER);
        jl17 = new JLabel("39",JLabel.CENTER);
        jl18 = new JLabel("",JLabel.CENTER);
        jl19 = new JLabel("",JLabel.CENTER);
        
        jcb1 = new JCheckBox("红烧肉");
	    jcb2 = new JCheckBox("红烧猪蹄");
	    jcb3 = new JCheckBox("家常炒面");
	    jcb4 = new JCheckBox("金牌海鲜炒饭");
	    jcb5 = new JCheckBox("糖醋排骨");
	    jcb6 = new JCheckBox("新奥尔良烤翅");
	    jcb7 = new JCheckBox("照烧鸡腿");   	    
	    
	    jp5.add(jl2);
	    jp5.add(jl3);
	    jp5.add(jl4);
	    jp5.add(jl11);
	    jp5.add(jl12);
	    jp5.add(jl13);
	    jp5.add(jcb1);				
	    jp5.add(jcb2);		
	    jp5.add(jcb3);
	    jp5.add(jl5);
	    jp5.add(jl6);
	    jp5.add(jl7);
	    jp5.add(jl14);
	    jp5.add(jl15);
	    jp5.add(jl16);
	    jp5.add(jcb4);				
	    jp5.add(jcb5);		
	    jp5.add(jcb6);
	    jp5.add(jl8);	    
	    jp5.add(jl9);
	    jp5.add(jl10);
	    jp5.add(jl17);
	    jp5.add(jl18);
	    jp5.add(jl19);
	    jp5.add(jcb7);				
	//甜品类
	    img=new ImageIcon("甜品类//红豆马蹄糕.jpg");      
        jl2 = new JLabel(img);      
        img=new ImageIcon("甜品类//红糖鸡蛋.jpg");          
        jl3 = new JLabel(img);
        img=new ImageIcon("甜品类//榴莲酥.jpg");          
        jl4 = new JLabel(img);
	    img=new ImageIcon("甜品类//芒果糯米糍.jpg");           
        jl5 = new JLabel(img);
        img=new ImageIcon("甜品类//全麦小餐包.jpg");          
        jl6 = new JLabel(img);
        img=new ImageIcon("甜品类//杂果榴莲冰.jpg");          
        jl7 = new JLabel(img);
        img=new ImageIcon("甜品类//紫薯汤圆.jpg");           
        jl8 = new JLabel(img);
        img=new ImageIcon();          
        jl9 = new JLabel(img);
        img=new ImageIcon();          
        jl10 = new JLabel(img);        
        
        jl11 = new JLabel("12",JLabel.CENTER);
        jl12 = new JLabel("12",JLabel.CENTER);
        jl13 = new JLabel("12",JLabel.CENTER);
        jl14 = new JLabel("12",JLabel.CENTER);
        jl15 = new JLabel("12",JLabel.CENTER);
        jl16 = new JLabel("12",JLabel.CENTER);
        jl17 = new JLabel("12",JLabel.CENTER);
        jl18 = new JLabel("",JLabel.CENTER);
        jl19 = new JLabel("",JLabel.CENTER);
        
        jcb1 = new JCheckBox("红豆马蹄糕");
	    jcb2 = new JCheckBox("红糖鸡蛋");
	    jcb3 = new JCheckBox("榴莲酥");
	    jcb4 = new JCheckBox("芒果糯米糍");
	    jcb5 = new JCheckBox("全麦小餐包");
	    jcb6 = new JCheckBox("杂果榴莲冰");
	    jcb7 = new JCheckBox("紫薯汤圆");    	    
	    
	    jp6.add(jl2);
	    jp6.add(jl3);
	    jp6.add(jl4);
	    jp6.add(jl11);
	    jp6.add(jl12);
	    jp6.add(jl13);
	    jp6.add(jcb1);				
	    jp6.add(jcb2);		
	    jp6.add(jcb3);
	    jp6.add(jl5);
	    jp6.add(jl6);
	    jp6.add(jl7);
	    jp6.add(jl14);
	    jp6.add(jl15);
	    jp6.add(jl16);
	    jp6.add(jcb4);				
	    jp6.add(jcb5);		
	    jp6.add(jcb6);
	    jp6.add(jl8);	    
	    jp6.add(jl9);
	    jp6.add(jl10);
	    jp6.add(jl17);
	    jp6.add(jl18);
	    jp6.add(jl19);
	    jp6.add(jcb7);				
	//饮品类
	    img=new ImageIcon("饮品类//补气养颜饮.jpg");      
        jl2 = new JLabel(img);      
        img=new ImageIcon("饮品类//玫瑰陈皮饮.jpg");          
        jl3 = new JLabel(img);
        img=new ImageIcon("饮品类//梅子冬瓜饮.jpg");          
        jl4 = new JLabel(img);
	    img=new ImageIcon("饮品类//木瓜红枣饮.jpg");           
        jl5 = new JLabel(img);
        img=new ImageIcon("饮品类//苹果牛奶饮.jpg");          
        jl6 = new JLabel(img);
        img=new ImageIcon("饮品类//苹果雪梨饮.jpg");          
        jl7 = new JLabel(img);
        img=new ImageIcon("饮品类//肉桂姜糖饮.jpg");           
        jl8 = new JLabel(img);
        img=new ImageIcon();          
        jl9 = new JLabel(img);
        img=new ImageIcon();          
        jl10 = new JLabel(img);        
        
        jl11 = new JLabel("28",JLabel.CENTER);
        jl12 = new JLabel("28",JLabel.CENTER);
        jl13 = new JLabel("28",JLabel.CENTER);
        jl14 = new JLabel("28",JLabel.CENTER);
        jl15 = new JLabel("28",JLabel.CENTER);
        jl16 = new JLabel("28",JLabel.CENTER);
        jl17 = new JLabel("28",JLabel.CENTER);
        jl18 = new JLabel("",JLabel.CENTER);
        jl19 = new JLabel("",JLabel.CENTER);
        
        jcb1 = new JCheckBox("补气养颜饮");
	    jcb2 = new JCheckBox("玫瑰陈皮饮");
	    jcb3 = new JCheckBox("梅子冬瓜饮");
	    jcb4 = new JCheckBox("木瓜红枣饮");
	    jcb5 = new JCheckBox("苹果牛奶饮");
	    jcb6 = new JCheckBox("苹果雪梨饮");
	    jcb7 = new JCheckBox("肉桂姜糖饮");	    	    
	    
	    jp7.add(jl2);
	    jp7.add(jl3);
	    jp7.add(jl4);
	    jp7.add(jl11);
	    jp7.add(jl12);
	    jp7.add(jl13);
	    jp7.add(jcb1);				
	    jp7.add(jcb2);		
	    jp7.add(jcb3);
	    jp7.add(jl5);
	    jp7.add(jl6);
	    jp7.add(jl7);
	    jp7.add(jl14);
	    jp7.add(jl15);
	    jp7.add(jl16);
	    jp7.add(jcb4);				
	    jp7.add(jcb5);		
	    jp7.add(jcb6);
	    jp7.add(jl8);	    
	    jp7.add(jl9);
	    jp7.add(jl10);
	    jp7.add(jl17);
	    jp7.add(jl18);
	    jp7.add(jl19);
	    jp7.add(jcb7);				
	    	       	  	  
	// 展示组件	       	    
	    jf = new JFrame("点菜系统");
	    jf.setSize(860, 635);
	    jf.setJMenuBar(jm1);
	    jf.setLayout(new BorderLayout(10,0)); //组件间距	    
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	  	
	    jf.setLocationRelativeTo(null);
	    jf.setVisible(true);
	    	  	 	
	    jf.add(jp1,BorderLayout.SOUTH);
	    jf.add(jl1,BorderLayout.NORTH);	    
	    jf.add(jtp,BorderLayout.CENTER);
	    jf.add(jtp2,BorderLayout.WEST);
	    jf.add(jp9,BorderLayout.EAST);
	    	    
	}
	
	//监听器
	public void actionPerformed(ActionEvent e) {		
	//判断哪个按钮被点击
		switch(e.getActionCommand()) {
		case "取消":
			ForJCheckBox(jp2);
			ForJCheckBox(jp3);
			ForJCheckBox(jp4);
			ForJCheckBox(jp5);
			ForJCheckBox(jp6);
			ForJCheckBox(jp7);
			break;
		case "下单":
			if(B && ForJCheckBoxnum(jp9)) {					    			    
				ForJCheckBoxStr(jp2,data,names,model,jt);
				ForJCheckBoxStr(jp3,data,names,model,jt);
				ForJCheckBoxStr(jp4,data,names,model,jt);
				ForJCheckBoxStr(jp5,data,names,model,jt);
				ForJCheckBoxStr(jp6,data,names,model,jt);
				ForJCheckBoxStr(jp7,data,names,model,jt);					
				jp9.add(jsp);
				B = false;
			}
			else if(ForJCheckBoxnum(jp9) == false) {
				JOptionPane.showMessageDialog(null, "请输入用餐人数", "下单错误", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "您已下单,若需要点菜请点击加单按钮", "下单错误", JOptionPane.ERROR_MESSAGE);
				ForJCheckBox(jp2);
				ForJCheckBox(jp3);
				ForJCheckBox(jp4);
				ForJCheckBox(jp5);
				ForJCheckBox(jp6);
				ForJCheckBox(jp7);
			}
			break;
		case "加单":	
			if(B == false) {			
				ForJCheckBoxStr(jp2,data,names,model,jt);
				ForJCheckBoxStr(jp3,data,names,model,jt);
				ForJCheckBoxStr(jp4,data,names,model,jt);
				ForJCheckBoxStr(jp5,data,names,model,jt);
				ForJCheckBoxStr(jp6,data,names,model,jt);
				ForJCheckBoxStr(jp7,data,names,model,jt);
				jp9.add(jsp);
			}
			else {
				JOptionPane.showMessageDialog(null, "您还未下单，请先点击下单按钮", "加单错误", JOptionPane.ERROR_MESSAGE);
				ForJCheckBox(jp2);
				ForJCheckBox(jp3);
				ForJCheckBox(jp4);
				ForJCheckBox(jp5);
				ForJCheckBox(jp6);
				ForJCheckBox(jp7);
			}	
			break;
		case "结账":
			if(jt.getRowCount() != 0) {
				int res = JOptionPane.showConfirmDialog(null, "是否继续操作", "结账提示", JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION) {
					JDialog FRAME = new JDialog();//构造一个新的JFrame，作为新窗口。
					FRAME.setSize(1000, 400);
					FRAME.setLocation(300, 200);
					FRAME.setBounds(new Rectangle((int) jf.getBounds().getX() + 50,(int) jf.getBounds().getY() + 50, (int) jf.getBounds().getWidth(), (int) jf.getBounds().getHeight()));											   
					FRAME.add(jsp,BorderLayout.NORTH);
					JButton button = new JButton("结账");
					FRAME.add(button,BorderLayout.WEST);
					button.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							FRAME.dispose();
						}
					});
					try {
						ForJCheckBoxnum(jp9,FRAME);
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}				
					FRAME.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);// 设置模式类型。					
					FRAME.setVisible(true);
					B = true;
					((DefaultTableModel)jt.getModel()).getDataVector().clear();// 清空前一人的菜单				
					break;
				} else {
					break;
				}
			}else {
				JOptionPane.showMessageDialog(null, "您还未下单，不能进行结账", "结账错误", JOptionPane.ERROR_MESSAGE);
				ForJCheckBox(jp2);
				ForJCheckBox(jp3);
				ForJCheckBox(jp4);
				ForJCheckBox(jp5);
				ForJCheckBox(jp6);
				ForJCheckBox(jp7);
			}
		case "热销菜式":
			jtp.setSelectedIndex(0);//切换卡片
			break;
		case "小炒类":
			jtp.setSelectedIndex(1);
			break;
		case "蔬菜类":
			jtp.setSelectedIndex(2);
			break;
		case "主食类":
			jtp.setSelectedIndex(3);
			break;
		case "甜品类":
			jtp.setSelectedIndex(4);
			break;
		case "饮品类":
			jtp.setSelectedIndex(5);
			break;
		}
	}
 
	//将已勾选的取消
	void ForJCheckBox(JPanel p) {
		int count = p.getComponentCount();
		for (int i = 0; i < count; i++) {
			Component comp = p.getComponent(i);
			if(comp instanceof JCheckBox){
				JCheckBox jcb = (JCheckBox)comp;
				if(jcb.isSelected()) {
					jcb.setSelected(false);				
				}
			}
		}
	}
 
	//记录餐桌号、用餐人数、时间、菜名、价格、总金额
	void ForJCheckBoxnum(JPanel p,JDialog FRAME) throws SQLException, IOException {
	 	String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	 	String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=shop";
	 	String userName="sa";
	 	String userPwd="123456";
		Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
		Statement state=dbConn.createStatement();
		PreparedStatement ps=dbConn.prepareStatement("insert into fo1(nu,name,bool) values(?,?,?)");
		for(int i=0; i<jt.getRowCount(); i++)
		{
	    	String str = (String)jt.getValueAt(i, 0);
			ps.setString(1,jg[jcb11.getSelectedIndex()]);
			ps.setString(2,str);
			ps.setInt(3,0);
			ps.executeUpdate();
		}
	
		int rowCount=jt.getRowCount();
		int sum = 0;
		String b = null;
	
    	for(int i=0; i<rowCount; i++) {
    		String str = (String)jt.getValueAt(i, 0);//取得第i行第一列的数据
    		str = ((String)jt.getValueAt(i, 1));//取得第i行第二列的数据
    		try {
        		int a = Integer.parseInt(str);
        		sum = sum+a;
        		b = Integer.toString(sum);
    		} 
			catch (NumberFormatException e) {
        		e.printStackTrace();
    		}
    	}
    
    	PreparedStatement ps2=dbConn.prepareStatement("insert into zo(桌号,人数,总金额) values(?,?,?)");
    	ps2.setString(1,jg[jcb11.getSelectedIndex()]);
		ps2.setString(2,jtf2.getText());
		ps2.setString(3,b);
		ps2.executeUpdate();
	
		JLabel JL = new JLabel("总金额:"+b,JLabel.CENTER);
		FRAME.add(JL,BorderLayout.SOUTH);
	}
 
	//判断是否输入用餐人数
	boolean ForJCheckBoxnum(JPanel p) {
		int count = p.getComponentCount();
		for(int i=0; i<count; i++) {
			Component comp = p.getComponent(i);
			if(comp instanceof JTextField) {
				JTextField jtf = (JTextField)comp;
				if(jtf.getText().equals(""))return false;
			}
		}return true;
	}
 
	//向JTable添加已点菜式及价格
	void ForJCheckBoxStr(JPanel p,Vector data,Vector names,DefaultTableModel model,JTable jt) {	
		int count = p.getComponentCount();
		for(int i=0; i<count; i++) {
			Component comp = p.getComponent(i);
			if(comp instanceof JCheckBox) {
				JCheckBox jcb = (JCheckBox)comp;
				if(jcb.isSelected()) {
					jcb.setSelected(false);	
					Component Comp = p.getComponent(i-3);
					JLabel jl = (JLabel)Comp;			
					Vector Row = new Vector();
					Row.add(jcb.getText());
					Row.add(jl.getText());
					data.add(Row.clone());
					model = new DefaultTableModel(data, names);				
					jt.setModel(model);
				}
			}
		}
	}
}