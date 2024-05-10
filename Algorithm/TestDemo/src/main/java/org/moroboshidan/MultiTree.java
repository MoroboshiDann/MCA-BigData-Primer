package org.moroboshidan;

import java.util.ArrayList;
import java.util.List;

public class MultiTree {
    int val;
    List<MultiTree> children;

    public MultiTree(int val) {
        this.val = val;
        children = new ArrayList<MultiTree>();
    }

    public MultiTree() {}
}
