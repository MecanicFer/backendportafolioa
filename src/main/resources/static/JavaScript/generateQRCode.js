const form = document.querySelector('form');
            const qrCodeImage = document.querySelector('#qrCodeImage');
            
            form.addEventListener('submit', event => {
                event.preventDefault();
                const link = document.querySelector('#link').value;
                const url = `/generateQRCode?link=${encodeURIComponent(link)}`;
                qrCodeImage.src = url;
                qrCodeImage.classList.remove('d-none');
            });
            
            function downloadQRCode() {
                const qrCodeImage = document.querySelector('#qrCodeImage');
                const url = qrCodeImage.src;
                const a = document.createElement('a');
                a.href = url;
                a.download = 'qr-code.png';
                document.body.appendChild(a);
                a.click();
                document.body.removeChild(a);
            }