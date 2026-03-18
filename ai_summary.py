import requests
import os

API_KEY = os.getenv("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")

def get_summary(log_text):
    url = "https://api.openai.com/v1/chat/completions"

    headers = {
        "Authorization": f"Bearer {API_KEY}",
        "Content-Type": "application/json"
    }

    data = {
        "model": "gpt-4o-mini",
        "messages": [
            {"role": "system", "content": "You are a QA assistant."},
            {"role": "user", "content": f"Analyze this test log and give failure summary:\n{log_text}"}
        ]
    }

    response = requests.post(url, headers=headers, json=data)
    return response.json()["choices"][0]["message"]["content"]


if __name__ == "__main__":
    with open("log.txt", "r") as f:
        log_data = f.read()

    summary = get_summary(log_data)

    with open("summary.txt", "w") as f:
        f.write(summary)