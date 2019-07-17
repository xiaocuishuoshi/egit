#20190506 
项目转换成maven管理，spring 从3.2.4.RELEASE 升级到4.3.14.RELEASE

==帐号
admin/whfp2019
武穴市公安局 hgadmin/123456

==20190507
1：角色，一个社区包含三种角色（社工、民警，社区医生）
2：戒毒人员档案包括（基本信息，关联责任人，家庭情况，纸质文书、尿检情况、谈话情况，风险评估），修改
3：增加的功能模块，谈话记录，尿检异地检查，走访，药品管理，（社工）绩效考核


==20190514
==尿检统计
SELECT man.*,
(SELECT count(1) from jd_kfjc j1 where j1.ryid = man.id and j1.sfzc="阴性") as num1,
(SELECT count(1) from jd_kfjc j2 where j2.ryid = man.id and j2.sfzc="阳性") as num2 
from jd_ryb man where man.id in (

	SELECT DISTINCT a.ryid from jd_kfjc a
)

==20190516
1:新增测试社区测试社工帐号： sq01_sg/123456,社区医生:sq01_ys01