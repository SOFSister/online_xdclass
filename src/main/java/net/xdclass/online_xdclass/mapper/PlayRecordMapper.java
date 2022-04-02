package net.xdclass.online_xdclass.mapper;

import net.xdclass.online_xdclass.model.entity.PlayRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Soft_Sister
 * @version : 1.0
 * @Project : online_xdclass
 * @Package : net.xdclass.online_xdclass.mapper
 * @ClassName : PlayRecordMapper.java
 * @createTime : 2022/3/8 20:51
 * @Email : 874280179@qq.com
 * @Description :
 */
@Mapper
public interface PlayRecordMapper {

    int save(PlayRecord playRecord);

}
