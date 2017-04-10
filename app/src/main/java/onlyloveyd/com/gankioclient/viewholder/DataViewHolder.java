package onlyloveyd.com.gankioclient.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import onlyloveyd.com.gankioclient.R;
import onlyloveyd.com.gankioclient.gsonbean.DataBean;
import onlyloveyd.com.gankioclient.utils.Constant;
import onlyloveyd.com.gankioclient.utils.PublicTools;

/**
 * Copyright 2017 yidong
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class DataViewHolder extends BaseViewHolder<DataBean.ResultsBean> {

    public DataViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindViewData(final DataBean.ResultsBean data) {

        if (data != null) {
            TextView tvTitle = (TextView) getView(R.id.tv_title);
            TextView tvAuthor = (TextView) getView(R.id.tv_author);
            TextView tvDate = (TextView) getView(R.id.tv_date);
            TextView tvType = (TextView) getView(R.id.tv_type);
            // 标题
            if (TextUtils.isEmpty(data.getDesc())) {
                tvTitle.setText("");
            } else {
                tvTitle.setText(data.getDesc().trim());
            }
            // 时间
            if (data.getPublishedAt() == null) {
                tvDate.setText("");
            } else {
                tvDate.setText(
                        PublicTools.getTimestampString(data.getPublishedAt()));
            }

            // 作者
            if (TextUtils.isEmpty(data.getWho())) {
                tvAuthor.setText("");
            } else {
                tvAuthor.setText(data.getWho());
            }

            if (TextUtils.isEmpty(data.getType())) {
                tvType.setText("");
            } else {
                tvType.setText(data.getType());
                tvType.setBackgroundResource(
                        Constant.sTypeColor.get(data.getType()));
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PublicTools.startWebActivity(itemView.getContext(), data.getUrl());
                }
            });
        }
    }
}
