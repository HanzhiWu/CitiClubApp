package com.example.citiclubapp.DataBase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.citiclubapp.Entity.CompanyInfo;
import com.example.citiclubapp.Entity.Warrant;

@Dao
public interface WarrantDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertWarrnts(Warrant... warrants);

    @Update
    public void updateWarrnt(Warrant... warrants);
    @Query("SELECT * FROM Warrant")
    public Warrant[] loadAllWarrant();
    @Query("SELECT * FROM Warrant WHERE companyAccount =:id")
    public Warrant[] findWarrantByCompany(int id);
    @Query("SELECT * FROM Warrant WHERE companyAccount= 7")
    public Warrant[] getSaleableWarrant();
    @Query("DELETE  FROM Warrant WHERE warrantID =:id")
    public void deleteExactWarrant(int id);
    @Query("SELECT * FROM Warrant WHERE warrantID =:id")
    public Warrant findWarrantinfoByid(int id);
    @Query("SELECT * FROM Warrant WHERE warrantID =:id and isConditionChange=:isConditionChange")
    public Warrant[] findNoticeWarrantinfoByid(int id,boolean isConditionChange);
    @Query("SELECT * FROM Warrant WHERE companyAccount =:id and conditionNode=8")
    public Warrant[] findZhiyaWarrantinfoByCompanyid(int id);
}
