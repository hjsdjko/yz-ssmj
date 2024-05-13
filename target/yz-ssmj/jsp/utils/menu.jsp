<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
var menus = [{
	"backMenu": [{
		"child": [{
			"buttons": ["修改", "删除"],
			"menu": "用户信息",
			"menuJump": "列表",
			"tableName": "yonghuxinxi"
		}],
		"menu": "用户管理"
	}, {
		"child": [{
			"buttons": ["修改", "新增", "删除"],
			"menu": "员工信息",
			"menuJump": "列表",
			"tableName": "yuangongxinxi"
		}],
		"menu": "员工管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "快递仓库信息",
			"menuJump": "列表",
			"tableName": "cangkuxinxi"
		}],
		"menu": "快递仓库管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "待发货信息",
			"menuJump": "列表",
			"tableName": "fahuoxinxi"
		}],
		"menu": "待发货管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "已收快递信息",
			"menuJump": "列表",
			"tableName": "shoujianxinxi"
		}],
		"menu": "已收快递管理"
	}, {
		"child": [{
			"buttons": ["修改", "删除"],
			"menu": "物流信息",
			"menuJump": "列表",
			"tableName": "wuliuxinxi"
		}],
		"menu": "物流管理"
	}, {
		"child": [{
			"buttons": ["修改", "删除"],
			"menu": "留言信息",
			"menuJump": "列表",
			"tableName": "liuyanxinxi"
		}],
		"menu": "留言管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "公告信息",
			"tableName": "xitonggonggao"
		}],
		"menu": "系统公告管理"
	}],
	"frontMenu": [],
	"roleName": "管理员",
	"tableName": "users"
}, {
	"backMenu": [{
		"child": [{
			"buttons": ["修改"],
			"menu": "员工信息",
			"menuJump": "列表",
			"tableName": "yuangongxinxi"
		}],
		"menu": "员工管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改"],
			"menu": "快递仓库信息",
			"menuJump": "列表",
			"tableName": "cangkuxinxi"
		}],
		"menu": "快递仓库管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改"],
			"menu": "待发货信息",
			"menuJump": "列表",
			"tableName": "fahuoxinxi"
		}],
		"menu": "待发货管理"
	}, {
		"child": [{
			"buttons": [],
			"menu": "已收快递信息",
			"menuJump": "列表",
			"tableName": "shoujianxinxi"
		}],
		"menu": "已收快递管理"
	}, {
		"child": [{
			"buttons": ["修改"],
			"menu": "物流信息",
			"menuJump": "列表",
			"tableName": "wuliuxinxi"
		}],
		"menu": "物流管理"
	}, {
		"child": [{
			"buttons": [],
			"menu": "留言信息",
			"menuJump": "列表",
			"tableName": "liuyanxinxi"
		}],
		"menu": "留言管理"
	}],
	"frontMenu": [],
	"roleName": "员工",
	"tableName": "yuangongxinxi"
}, {
	"backMenu": [{
		"child": [{
			"buttons": ["修改"],
			"menu": "用户信息",
			"menuJump": "列表",
			"tableName": "yonghuxinxi"
		}],
		"menu": "用户管理"
	}, {
		"child": [{
			"buttons": ["签收"],
			"menu": "快递仓库信息",
			"menuJump": "列表",
			"tableName": "cangkuxinxi"
		}],
		"menu": "快递仓库管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改"],
			"menu": "待发货信息",
			"menuJump": "列表",
			"tableName": "fahuoxinxi"
		}],
		"menu": "待发货管理"
	}, {
		"child": [{
			"buttons": [],
			"menu": "已收快递信息",
			"menuJump": "列表",
			"tableName": "shoujianxinxi"
		}],
		"menu": "已收快递管理"
	}, {
		"child": [{
			"buttons": [],
			"menu": "物流信息",
			"menuJump": "列表",
			"tableName": "wuliuxinxi"
		}],
		"menu": "物流管理"
	}, {
		"child": [{
			"buttons": [],
			"menu": "留言信息",
			"menuJump": "列表",
			"tableName": "liuyanxinxi"
		}],
		"menu": "留言管理"
	}, {
		"child": [{
			"buttons": [],
			"menu": "公告信息",
			"tableName": "xitonggonggao"
		}],
		"menu": "系统公告管理"
	}],
	"frontMenu": [],
	"roleName": "用户",
	"tableName": "yonghuxinxi"
}];

var hasMessage = '';
