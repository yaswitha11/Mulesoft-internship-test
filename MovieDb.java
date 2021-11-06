import java.sql.*;
public class MovieDb {

  public static void main(String args[]) throws Exception
  {
	  Class.forName("org.sqlite.JDBC");
    String url="jdbc:sqlite:movies.db";
    Connection con=DriverManager.getConnection(url);
    if(con!=null)
    {
      
      Statement stmt=con.createStatement();
      stmt.executeUpdate("create table movies(name text primary key,actor text,actress text,director text,yearofrelease int)");
        System.out.println("table created");
        
        
        stmt.executeUpdate("insert into movies values('Saaho','Prabhas','Shraddha Kapoor','Sujeeth',2019)");
        stmt.executeUpdate("insert into movies values('Mirchi','Prabhas','Anushka Shetty','Koratala Siva',2013)");
        stmt.executeUpdate("insert into movies values('Varsham','Prabhas','Trisha','Sobhan',2004)");
        stmt.executeUpdate("insert into movies values('Munna','Prabhas','Ileana','Vamshi Paidipally',2007)");
        stmt.executeUpdate("insert into movies values('Rebel','Prabhas','Tamannaa','Raghava Lawrence ',2012)");
        stmt.executeUpdate("insert into movies values('Sarileru Neekevvaru',  'Mahesh Babu','Rashmika Mandanna','Anil Ravipudi',2020)");
        stmt.executeUpdate("insert into movies values('Bharat Ane Nenu','Mahesh Babu','Kiara Advani','Koratala Siva',2018)");
        stmt.executeUpdate("insert into movies values('Spyder','Mahesh Babu','Rakul Preet Singh','A.R. Murugadoss',2017)");
        stmt.executeUpdate("insert into movies values('Maharshi','Mahesh Babu','Pooja Hegde','Vamshi Paidipally',2019)");
        stmt.executeUpdate("insert into movies values('Pokiri','Mahesh Babu','Ileana','Puri Jagannadh',2006)");
        stmt.executeUpdate("insert into movies values('Geetha Govindam','Vijay Deverakonda','Rashmika Mandanna','Parasuram',2018");
        stmt.executeUpdate("insert into movies values('Taxiwala','Vijay Deverakonda','Priyanka Jawalkar','Rahul Sankrityan',2018)");
        stmt.executeUpdate("insert into movies values('Nota','Vijay Deverakonda','Mehreen Kaur Pirzada','Anand Shankar',2018)");
        stmt.executeUpdate("insert into movies values('Dear Comrade','Vijay Deverakonda','Rashmika Mandanna','Bharat Kamma',2019)");
        stmt.executeUpdate("insert into movies values('Nuvvila','Vijay Deverakonda','Yami Gautam','Ravi Babu',2011)");
        
        PreparedStatement pstmt=con.prepareStatement("select * from movies");
        ResultSet rs=pstmt.executeQuery();
        while(rs.next())
        {
          System.out.println(rs.getString("name")+"  "+rs.getString("actor")+"  "+rs.getString("actress")+"  "+rs.getString("director")+"  "+rs.getInt("yearofrelease"));
        }
        PreparedStatement pstmt1=con.prepareStatement("select * from movies where actor='Vijay Deverakonda'");
        ResultSet rs1=pstmt1.executeQuery();
        while(rs1.next())
        {
          System.out.println(rs.getString("name")+"  "+rs.getString("actor")+"  "+rs.getString("actress")+"  "+rs.getString("director")+"  "+rs.getInt("yearofrelease"));
        }
        
        
        
    }
   
    con.close();    
  }
}