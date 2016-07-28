package model;

import java.sql.Date;
import java.util.List;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.MatchingNamingConvention;
import com.avaje.ebean.config.ServerConfig;


public class AccountingModelTest {

    public static void main(String[] args) {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriver("com.mysql.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://172.31.1.136/marginSystem");
        dsc.setUsername("root");
        dsc.setPassword("a");
        
        ServerConfig config = new ServerConfig();
        config.setName("default");
        config.setDataSourceConfig(dsc);
        config.setDdlGenerate(false);
        config.setDdlRun(false);
        config.setDefaultServer(true);
        config.setRegister(true);
        config.setNamingConvention(new MatchingNamingConvention());
        
        EbeanServer server = EbeanServerFactory.create(config);
        System.err.println(server.createSqlQuery("show tables").findList().size());
        System.err.println(server.createQuery(AccountingModel.class).findRowCount());
        List<AccountingModel> list = server.createQuery(AccountingModel.class).findList();
        System.err.println(list.get(0).date);
        System.err.println(AccountingModel.me.findRowCount());
        
        AccountingModel am = new AccountingModel();
        am.date = new Date(System.currentTimeMillis());
        am.remark = "xxx";
        am.lastUpdateTime = (int) (System.currentTimeMillis() / 1000);
        //am.save();
        
        am = list.get(0);
        am.setRemark("xxxxx");
        am.lastUpdateTime = (int) (System.currentTimeMillis() / 1000);
        //am.update("default");
        server.update(am);
        
        am = list.get(2);
        //am.delete();
    }
}
