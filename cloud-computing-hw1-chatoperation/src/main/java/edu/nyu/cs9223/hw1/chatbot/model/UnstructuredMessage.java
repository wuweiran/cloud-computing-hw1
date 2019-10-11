/**
 * null
 */
package edu.nyu.cs9223.hw1.chatbot.model;

import java.io.Serializable;

/**
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ljp1k3l5m2-1.0.0/UnstructuredMessage" target="_top">AWS API
 * Documentation</a>
 */
public class UnstructuredMessage implements Serializable, Cloneable {

    private String id;

    private String text;

    private String timestamp;

    /**
     * @return
     */

    public String getId() {
        return this.id;
    }

    /**
     * @param id
     */

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param id
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UnstructuredMessage id(String id) {
        setId(id);
        return this;
    }

    /**
     * @return
     */

    public String getText() {
        return this.text;
    }

    /**
     * @param text
     */

    public void setText(String text) {
        this.text = text;
    }

    /**
     * @param text
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UnstructuredMessage text(String text) {
        setText(text);
        return this;
    }

    /**
     * @return
     */

    public String getTimestamp() {
        return this.timestamp;
    }

    /**
     * @param timestamp
     */

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @param timestamp
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UnstructuredMessage timestamp(String timestamp) {
        setTimestamp(timestamp);
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and debugging.
     *
     * @return A string representation of this object.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getId() != null)
            sb.append("Id: ").append(getId()).append(",");
        if (getText() != null)
            sb.append("Text: ").append(getText()).append(",");
        if (getTimestamp() != null)
            sb.append("Timestamp: ").append(getTimestamp());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (obj instanceof UnstructuredMessage == false)
            return false;
        UnstructuredMessage other = (UnstructuredMessage) obj;
        if (other.getId() == null ^ this.getId() == null)
            return false;
        if (other.getId() != null && other.getId().equals(this.getId()) == false)
            return false;
        if (other.getText() == null ^ this.getText() == null)
            return false;
        if (other.getText() != null && other.getText().equals(this.getText()) == false)
            return false;
        if (other.getTimestamp() == null ^ this.getTimestamp() == null)
            return false;
        if (other.getTimestamp() != null && other.getTimestamp().equals(this.getTimestamp()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getId() == null) ? 0 : getId().hashCode());
        hashCode = prime * hashCode + ((getText() == null) ? 0 : getText().hashCode());
        hashCode = prime * hashCode + ((getTimestamp() == null) ? 0 : getTimestamp().hashCode());
        return hashCode;
    }

    @Override
    public UnstructuredMessage clone() {
        try {
            return (UnstructuredMessage) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }
}
