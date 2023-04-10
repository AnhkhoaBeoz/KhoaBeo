/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.thao.Services.DatabaseConnection;
import com.thao.Services.KhoaBeoTimVeService;
import com.thao.Services.KhoaBeoVeXeService;
import com.thao.pojo.Ve;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 *
 * @author anhkh
 */
public class TimVeTester {
    private static Connection conn;
    private static KhoaBeoVeXeService kb;
    @BeforeAll
    public static void BeforeAll() throws SQLException{
        conn = DatabaseConnection.getDBConnection();
        kb = new KhoaBeoVeXeService();
    }
    @AfterAll
    public static void afterAll() throws SQLException {
        if(conn!=null)
            conn.close();
    }
    @Test
    public void TimVeSearch() throws SQLException {
        List<Ve> ves = kb.getListVe("fccb720a-3e6f-4949-8876-43a42211fbad");
        Assertions.assertEquals(1,ves.size());
        for(Ve v : ves){
            Assertions.assertTrue(v.getId().contains("fccb720a-3e6f-4949-8876-43a42211fbad"));
        }
    }
     public void TimVeSearch2() throws SQLException {
        List<Ve> ves = kb.getVe();
        Assertions.assertEquals(1,ves.size());
        for(Ve v : ves){
            Assertions.assertTrue(v.getId().contains("fccb720a-3e6f-4949-8876-43a42211fbad"));
        }
    }
}
