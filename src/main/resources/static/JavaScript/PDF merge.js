/* JS code to download the unified PDF*/        
            function downloadPDF() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', '/merge', true);
    xhr.responseType = 'blob';
    xhr.onload = function(e) {
        if (this.status == 200) {
            var blob = new Blob([this.response], { type: 'application/pdf' });
            var link = document.createElement('a');
            link.href = window.URL.createObjectURL(blob);
            link.download = 'merged.pdf';
            link.click();
        }
    };
    xhr.send();
}