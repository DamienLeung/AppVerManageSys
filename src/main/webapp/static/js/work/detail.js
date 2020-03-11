let vm = new Vue({
    el: "#main-container",
    data: {
        code: "",
        work: {}
    },
    methods: {
        getDetail: function () {
            axios({
                url:`manage/work/getDetail/${this.code}`
            }).then(response => {
                this.work = response.data.object;
            })
        }
    },
    created: function () {
        this.code = parent.layer.obj;
        this.getDetail();
    }
});