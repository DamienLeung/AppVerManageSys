let vm = new Vue({
    el: "#main-container",
    data: {
        qua: {}
    },
    methods: {
        doUpdate:function (check) {
            this.qua.check = check;
            axios({
                url:'manage/qualification/doUpdate',
                method:'post',
                data:this.qua
            }).then (response => {
                if (response.data.success) {
                    let frameIndex = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(frameIndex);
                    parent.layer.msg(response.data.msg);
                } else {
                    layer.msg(response.data.msg);
                }
            }).catch (error => {
                layer.msg(error.message);
            })
        }
    },
    created: function () {
        this.qua = parent.layer.obj;
    }
});