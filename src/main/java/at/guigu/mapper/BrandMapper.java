package at.guigu.mapper;

import at.guigu.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    /*@Select("select * from tb_brand")
    @ResultMap("brandResultMap")*/
    List<Brand> selectAll();
    //@Insert("insert into tb_brand values (null, #{brandName}, #{companyName}, #{ordered}, #{description}, #{status})")
    void add(Brand brand);

    /**
     * //修改——回显数据：根据id查询
     * @param id
     * @return
     */
    /*@Select("select * from tb_brand where id = #{id}")
    @ResultMap("brandResultMap")*/
    Brand selectById(int id);

    //修改——修改数据
    void update(Brand brand);
}
