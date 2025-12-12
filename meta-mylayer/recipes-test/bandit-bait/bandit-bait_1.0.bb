SUMMARY = "Intentionally insecure Python application for Bandit testing"
LICENSE = "CLOSED"


SRC_URI = "file://insecure_app.py"

S = "${UNPACKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 insecure_app.py ${D}${bindir}/insecure_app
}

# Minimal deps so recipe is always buildable
RDEPENDS:${PN} = "python3-core python3-pyyaml"
