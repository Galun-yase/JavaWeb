package com.chengzi.dao.impl;

import com.chengzi.pojo.Book;

import java.util.List;

public class BookDaoImpl  extends BaseDao implements BookDao{

    @Override
    public int addBook(Book book) {
        String sql="insert into tb_house_resources(title,building_num,building_unit,building_floor_num,rent,orientation,contact,mobile)values(?,?,?,?,?,?,?,?)";

        return update(sql,book.getTitle(),21,7,209,book.getRent(),book.getOrientation(),book.getContact(),book.getMobile());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql="delete from tb_house_resources where id=?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql="update tb_house_resources set title=?,rent=?,orientation=?,contact=?,mobile=? where id=?";
        return update(sql,book.getTitle(),book.getRent(),book.getOrientation(),book.getContact(),book.getMobile(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql="select title,building_num,building_unit,building_floor_num,rent,orientation,contact,mobile from tb_house_resources where id=?";
        return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql="select title,building_num,building_unit,building_floor_num,rent,orientation,contact,mobile from tb_house_resources";
        return queryForList(Book.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql="select count(*) from tb_house_resources";
        Number count=(Number)queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql="select id,title,building_num,building_unit,building_floor_num,rent,orientation,contact,mobile from tb_house_resources limit ?,?";
        return queryForList(Book.class,sql,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql="select count(*) from tb_house_resources where price between ? and ?";
        Number count=(Number)queryForSingleValue(sql,min,max);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql="select title,building_num,building_unit,building_floor_num,rent,orientation,contact,mobile from tb_house_resources where price between ? and ? limit ?,?";
        return queryForList(Book.class,sql,min,max,begin,pageSize);
    }
}
