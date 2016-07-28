package model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.avaje.ebean.Model;

/**
 * Created by swrd on 4/5/16.
 */
@Entity
@Table(name = "accounting")
public class AccountingModel extends Model {
    @Id
    public Integer id;
    public Date date;
    public Integer lastUpdateTime;
    public String remark;
    public Timestamp ts;

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static Finder<Long, AccountingModel> me = new Finder<Long, AccountingModel>(AccountingModel.class);

}
