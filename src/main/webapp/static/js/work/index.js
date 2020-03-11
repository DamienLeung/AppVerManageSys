let mv = new Vue ({
    el: "#main-container",
    data: function () {
        return {
            settings: {
                data: {
                    key: {},
                    simpleData: {
                        enable: true,
                        pIdKey: "parentId"
                    }
                },
                callback: {
                    onClick: this.onClick
                },
                view: {
                    fontCss: this.fontCss
                }
            },
            name: "",
            pageInfo: {
                pageNum: 1,
                pageSize: 5
            },
            flag: true,
            title: "全部",
            parameters: {
                status: ""
            },
            num: 0
        }
    },
    methods: {
        list: function (pageNum, pageSize) {
            axios ({
                url: `manage/work/listPage/${pageNum}/${pageSize}`,
                method: 'post',
                data: this.parameters
            }).then (response => {
                this.pageInfo = response.data.object;
            })
        },
        listAll: function (pageNum, pageSize) {
            this.parameters = {status: ""};
            this.list(pageNum, pageSize);
        },
        initTree: function () {
            axios ({
                url: "manage/office/listAll"
            }).then (response => {
                let nodes = response.data.object;
                nodes[nodes.length] = {id: 0, name: "全部", open: true};
                let treeObj = $.fn.zTree.init($('#pullDownTreeone'), this.settings, nodes);
            })
        },
        onClick: function (event, treeId, treeNode) {
            if (treeNode.id === 0) {
                this.parameters = {status: ""};
                this.title = "全部";
            } else {
                this.title = treeNode.name;
                this.parameters.officeId = treeNode.id;
            }
            event.stopPropagation();
        },
        search: function () {
            let zTreeObj = $.fn.zTree.getZTreeObj("pullDownTreeone");
            let nodes = zTreeObj.getNodesByParamFuzzy("name", this.name);
            let allNodes = zTreeObj.getNodes();
            allNodes = zTreeObj.transformToArray(allNodes);
            for (let i = 0; i < allNodes.length; i ++) {
                allNodes[i].highLight = false;
                zTreeObj.updateNode(allNodes[i]);
            }
            for (let i = 0; i < nodes.length; i ++) {
                nodes[i].highLight = true;
                zTreeObj.updateNode(nodes[i]);
            }
        },
        fontCss: function (treeId, treeNode) {
            return treeNode.highLight ? {color: 'red'} : {color: 'black'};
        },
        changeFlag: function () {
            this.flag = !this.flag;
        },
        toDetail: function (obj) {
            layer.obj = obj;
            layer.open({
                type: 2,
                content: "manage/work/toWorkDetail",
                area: ['50%', '80%']
            })
        }
    },
    created: function () {
        this.listAll(this.pageInfo.pageNum, this.pageInfo.pageSize);
    },
    mounted: function () {
        this.initTree();
    }

});

$(function () {
    $("div.dropdown-menu").on("click", ".ztree .switch,#pullDownTreeSearchone,.scroll-track", function(e) {e.stopPropagation(); });

    $('.scrollable').each(function () {
        var $this = $(this);
        $(this).ace_scroll({
            size: $this.data('height') || 250
        });
    });
})