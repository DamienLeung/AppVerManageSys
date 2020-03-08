let vm = new Vue({
    el:"#main-container",
    data:{
        pageInfo:{
            pageNum:1,
            pageSize:5
        },
        conditions:{
            type:null
        },
        num:0
    },
    methods:{
        listAll:function (pageNum, pageSize) {
            axios({
                url:`manage/qualification/listPage/${pageNum}/${pageSize}`,
                method:"post",
                data:this.conditions
            }).then(response=>{
                this.pageInfo = response.data.object;
            })
        },
        select:function (pageNum, pageSize) {
            this.conditions = {
                type:"",
                check:""
            };
            this.listAll(pageNum, pageSize);
        },
        toUpdate:function (obj) {
            layer.obj = obj;
            layer.open({
                type:2,
                title:'更新qualification',
                content:'manage/qualification/toUpdate',
                area:['50%', '80%']
            })
        }

    },
    created:function () {
        console.log(this.conditions);
        this.listAll(this.pageInfo.pageNum, this.pageInfo.pageSize);
    }
});