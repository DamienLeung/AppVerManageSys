let vm = new Vue({
    el: "#main-container",
    data: {
        version:{}
    },
    methods: {
        doUpdate:function () {
            axios({
                url:'manage/app/update',
                method:'put',
                data:this.version
            }).then(response=>{
                console.log(response);
                if (response.data.success) {
                    let frameIndex = parent.layer.getFrameIndex(window.name);
                    console.log(frameIndex);
                    parent.layer.close(frameIndex);
                    parent.layer.msg(response.data.msg);
                } else {//失败: 显示提示
                    layer.msg(response.data.msg);
                }

            }).catch(error=>{
                layer.msg(error.message)
            })
        }

    },
    created: function () {
        this.version = parent.layer.obj;
    }
})