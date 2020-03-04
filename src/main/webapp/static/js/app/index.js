let vm = new Vue({
    el:"#main-container",
    data:{
        pageInfo:{
            pageNum:1,
            pageSize:5
        },
        // appVersions:[],
        version:{},
        flag:true,
        num:0
    },
    methods:{
        listAll:function (pageNum, pageSize) {
            axios({
                url:`manage/app/listPage/${pageNum}/${pageSize}`
            }).then(response=>{
                this.pageInfo = response.data.object;
            })
        },
        toUpdate:function (obj) {
            layer.obj = obj;
            layer.open({
                type:2,
                title:'更新app資料',
                content:'manage/app/toUpdate',
                area:['50%', '80%']
            })
        },
        doDelete:function (obj) {
            obj.delFlag = "1";
            axios({
                url:"manage/app/delete",
                method:"delete",
                data:obj
            }).then(response=>{
                if (response.data.success) {
                    this.listAll(this.pageInfo.pageNum, this.pageInfo.pageSize);
                    layer.msg(response.data.msg);
                } else {
                    layer.msg(response.data.msg);
                }
            }).catch(error=>{
                layer.msg(error.message);
            })
        },
        insert:function () {
            this.flag = false;
            axios({
                url:"manage/app/insert",
                method:"post",
                data:this.version
            }).then(response=>{
                if (response.data.success) {
                    this.flag = true;
                    this.listAll(this.pageInfo.pageNum, this.pageInfo.pageSize);
                    layer.msg(response.data.msg);
                    this.version = {};
                } else {
                    layer.msg(response.data.msg);
                }
            }).catch(error=>{
                layer.msg(error.message);
            })
        }
    },
    created:function () {
        this.listAll(this.pageInfo.pageNum, this.pageInfo.pageSize);
    }
});