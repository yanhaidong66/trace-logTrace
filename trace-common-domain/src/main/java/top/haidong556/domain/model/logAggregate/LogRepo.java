package top.haidong556.domain.model.logAggregate;

import java.util.List;

public interface LogRepo {

    /**
     * 保存一个 LogAggregateRoot 实体
     * @param logAggregateRoot 需要保存的实体
     * @return 保存后的实体
     */
    LogAggregateRoot save(LogAggregateRoot logAggregateRoot);

    /**
     * 根据 ID 查找 LogAggregateRoot
     * @param id 实体的唯一 ID
     * @return 如果存在返回实体，否则返回 null
     */
    LogAggregateRoot findById(String id);

    /**
     * 获取所有 LogAggregateRoot 记录
     * @return 返回所有的 LogAggregateRoot
     */
    List<LogAggregateRoot> findAll();

    /**
     * 删除指定 ID 的 LogAggregateRoot
     * @param id 需要删除的实体 ID
     * @return 是否删除成功
     */
    boolean deleteById(String id);

    /**
     * 统计 LogAggregateRoot 的总数
     * @return 记录数
     */
    long count();

    /**
     * 根据某个时间戳范围查询 LogAggregateRoot
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 匹配的实体列表
     */
    List<LogAggregateRoot> findByTimestampRange(String startTime, String endTime);

    /**
     * 保存一个 LogAggregateRoot 实体
     * @param logAggregateRoot 需要保存的实体
     * @return 是否存在，返回false则没找到并且保存了
     */
    boolean saveIfNotFound(LogAggregateRoot logAggregateRoot);
}
