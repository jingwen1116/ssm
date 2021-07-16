function delcfm() {
    if (!confirm("确认要删除？")) {
        window.event.returnValue = false;
    }
}