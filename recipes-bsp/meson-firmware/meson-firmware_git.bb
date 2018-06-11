SUMMARY = "Firmware for amlogic vdec"
LICENSE = "Propietary"


SRC_URI = "git://github.com/chewitt/meson-firmware.git;protocol=https"
SRCREV = "b9b622ea75d1df9c559f1d1e7a2d24a09657aec6"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${nonarch_baselibdir}/firmware/
	cp -a ${S}/meson ${D}${nonarch_base_libdir}/firmware/ 
}
