SUMMARY = "Firmware for amlogic vdec"
LICENSE = "GPLv2"


SRC_URI = "git://github.com/chewitt/meson-firmware.git;protocol=https"
SRCREV = "0db131d984855b377d9cf61ff2dd1b4c6c2e9dca"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${nonarch_baselibdir}/firmware/
	cp -a ${S}/meson ${D}${nonarch_base_libdir}/firmware/ 
}
