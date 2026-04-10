#!/bin/bash
set -e

echo "Installing msmtp..."
sudo apt-get install -y msmtp > /dev/null 2>&1

cat > ~/.msmtprc << EOF
account default
host smtp.gmail.com
port 587
auth on
tls on
tls_starttls on
user ${EMAIL_USER}
password ${EMAIL_PASSWORD}
from ${EMAIL_USER}
EOF

chmod 600 ~/.msmtprc

if [ "$BUILD_STATUS" = "success" ]; then
  SUBJECT="✅ CI Build SUCCESS - ${REPOSITORY}"
else
  SUBJECT="❌ CI Build FAILED - ${REPOSITORY}"
fi

MESSAGE=$(cat << EOF
To: ${NOTIFICATION_EMAIL}
From: ${EMAIL_USER}
Subject: ${SUBJECT}
Content-Type: text/plain; charset=UTF-8

Pipeline Result: ${BUILD_STATUS^^}

Repository : ${REPOSITORY}
Branch     : ${BRANCH}
Commit     : ${COMMIT_SHA}
Triggered by: ${ACTOR}

-- CI/CD Automated Notification
EOF
)

echo "$MESSAGE" | msmtp "$NOTIFICATION_EMAIL"

echo "Notification sent to ${NOTIFICATION_EMAIL}"
